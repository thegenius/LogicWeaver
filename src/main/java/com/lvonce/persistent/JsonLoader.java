package com.lvonce.persistent;

import java.util.ArrayList;
import java.math.BigDecimal;
import com.lvonce.BehaviorDebug;

/**
 * Created by WangWei on 2017/3/16.
 */
public class JsonLoader {
    public static class JsonPair {
        public String key;
        public JsonValue value;
        public JsonPair(String key, JsonValue value) {
            this.key = key;
            this.value = value;
        }
    }
    public static class JsonObject {
        public JsonPair[] pairs;
        public JsonObject(ArrayList<JsonPair> list) {
            this.pairs = new JsonPair[list.size()];
            list.toArray(this.pairs);
        }
    }
    public static class JsonArray {
        public JsonValue[] values;
        public JsonArray(ArrayList<JsonValue> list) {
            this.values = new JsonValue[list.size()];
            list.toArray(this.values);
        }
    }
    public static class JsonValue {
        public enum TYPE {STRING, NUMBER, OBJECT, ARRAY, TRUE, FALSE, NULL};
        public TYPE type;
        public Object value;
        public Object[] list;
        public  JsonValue(){
            this.type = TYPE.NULL;
            this.value = null;
        }
        public JsonValue(String string) {
            this.type = TYPE.STRING;
            this.value = string;
        }
        public JsonValue(BigDecimal number) {
            this.type = TYPE.NUMBER;
            this.value = number;
        }
        public JsonValue(boolean bool) {
            this.type = bool ? TYPE.TRUE : TYPE.FALSE;
            this.value = bool;
        }
        public JsonValue(JsonObject obj) {
            this.type = TYPE.OBJECT;
            this.list = obj.pairs;
        }
        public JsonValue(JsonArray array) {
            this.type = TYPE.ARRAY;
            this.list = array.values;
        }
    }

    public static class LoaderIndex {
        public int value = 0;
    };

    public static class UnexpectedCharException extends Exception {
        UnexpectedCharException(char expected, char found) {
            System.out.printf("- Parse Error: %s is expected, but %s found! -\n", expected, found);
        }
    }
    public static class UnknownTypeException extends Exception {
        UnknownTypeException(String found) {
            System.out.printf("- Parse Error: type %s is not valid! -\n");
        }
    }
    public static class UnexpectedString extends Exception {
        UnexpectedString(String expected, String found) {
            System.out.printf("- Parse Error: %s is expected, but %s found! -\n", expected, found);
        }
    }

    public static void skip(char[] chars, LoaderIndex index) throws StringIndexOutOfBoundsException {
        while (true) {
            char ch = chars[index.value];
            if (ch == ' ' || ch == '\t' || ch == '\r') {
                ++index.value;
            } else {
                return;
            }
        }
    }

    public static void eat(char[] chars, char ch, LoaderIndex index) throws UnexpectedCharException {
        skip(chars, index);
        if (chars[index.value] == ch) {
            ++index.value;
        } else {
            throw new UnexpectedCharException(ch, chars[index.value]);
        }
    }
    public static void eat(char[] chars, char[] chs, LoaderIndex index) throws UnexpectedString {
        skip(chars, index);
        int charsBegin = index.value;
        for (char ch : chs) {
            if (ch == chars[index.value]) {
                ++ index.value;
            } else {
                StringBuilder builder1 = new StringBuilder();
                StringBuilder builder2 = new StringBuilder();
                builder1.append(chs, 0, chs.length);
                builder2.append(chars, charsBegin, chs.length);
                throw new UnexpectedString(builder1.toString(), builder2.toString());
            }
        }
    }

    public static void eatUntil(char[] chars, char ch, LoaderIndex index) throws StringIndexOutOfBoundsException {
        skip(chars, index);
        while (chars[index.value] != ch) {
            ++index.value;
        }
    }

    public static String generateString(char[] chars, int begin, int end) {
        StringBuilder builder = new StringBuilder();
        builder.append(chars, begin, end - begin);
        return builder.toString();
    }

    public static JsonValue loadString(char[] chars, LoaderIndex index) throws UnexpectedCharException {
        eat(chars, '"', index);
        int stringBegin = index.value;
        eatUntil(chars, '"', index);
        int stringEnd = index.value;
        String string = generateString(chars, stringBegin, stringEnd);
        eat(chars, '"', index);
        return new JsonValue(string);
    }

    public static JsonValue loadNumber(char[] chars, LoaderIndex index) {
        skip(chars, index);
        int numberBegin = index.value;
        char ch = chars[index.value];
        while (Character.isDigit(ch) || ch == '+' || ch == '-' || ch=='e' || ch=='E') {
            ++ index.value;
        }
        int numberEnd = index.value;
        String string = generateString(chars, numberBegin, numberEnd);
        return new JsonValue(new BigDecimal(string));
    }

    public static JsonValue loadNull(char[] chars, LoaderIndex index) throws UnexpectedString {
        eat(chars, "null".toCharArray(), index);
        return new JsonValue();
    }

    public static JsonValue loadTrue(char[] chars, LoaderIndex index) throws UnexpectedString {
        eat(chars, "true".toCharArray(), index);
        return new JsonValue(true);
    }

    public static JsonValue loadFalse(char[] chars, LoaderIndex index) throws UnexpectedString {
        eat(chars, "false".toCharArray(), index);
        return new JsonValue(false);
    }

    public static JsonPair loadPair(char[] chars, LoaderIndex index) throws UnexpectedCharException, UnexpectedString, UnknownTypeException {
        //BehaviorDebug.incLevel();
        //BehaviorDebug.debug("loadPair()");
        String keyName = (String)loadString(chars, index).value;
        eat(chars, ':', index);
        JsonValue value = loadValue(chars, index);
        //BehaviorDebug.debug("pair: keyname:%s : value type:%s : %s", keyName, value.type.toString(), value.value);
        //BehaviorDebug.decLevel();
        return new JsonPair(keyName, value);
    }

    public static JsonValue loadObject(char[] chars, LoaderIndex index) throws UnexpectedCharException, UnexpectedString, UnknownTypeException {
        //BehaviorDebug.incLevel();
        //BehaviorDebug.debug("loadObject()");
        eat(chars, '{', index);
        skip(chars, index);
        ArrayList<JsonPair> members = new ArrayList<>();
        while (chars[index.value] != '}') {
            members.add(loadPair(chars, index));
            skip(chars, index);
            if (chars[index.value] == ',') {
                ++ index.value;
            }
        }
        eat(chars, '}', index);
        BehaviorDebug.decLevel();
        return new JsonValue(new JsonObject(members));
    }

    public static JsonValue loadArray(char[] chars, LoaderIndex index)throws UnexpectedCharException, UnexpectedString, UnknownTypeException {
        BehaviorDebug.incLevel();
        BehaviorDebug.debug("loadArray()");
        eat(chars, '[', index);
        skip(chars, index);
        ArrayList<JsonValue> values = new ArrayList<>();
        while (chars[index.value] != ']') {
            values.add((JsonValue) loadValue(chars, index));
            skip(chars, index);
            if (chars[index.value] == ',') {
                ++ index.value;
            }
        }
        eat(chars, ']', index);
        BehaviorDebug.decLevel();
        return new JsonValue(new JsonArray(values));
    }

    public static JsonValue loadValue(char[] chars, LoaderIndex index) throws UnexpectedCharException, UnexpectedString, UnknownTypeException {
        skip(chars, index);
        char ch = chars[index.value];
        if (Character.isDigit(ch)) {
            return loadNumber(chars, index);
        }
        switch (ch) {
            case '"': return loadString(chars, index);
            case 'n': return loadNull(chars, index);
            case 't': return loadTrue(chars, index);
            case 'f': return loadFalse(chars, index);
            case '{': return loadObject(chars, index);
            case '[': return loadArray(chars, index);
            case '-': return loadNumber(chars, index);
            default:
                throw new UnknownTypeException("not valid json format");
        }
    }

    public static JsonValue load(String behaviorString) throws UnexpectedCharException, UnexpectedString, UnknownTypeException  {
        LoaderIndex index = new LoaderIndex();
        JsonValue value =  loadValue(behaviorString.toCharArray(), index);
        return value;
    }
}
