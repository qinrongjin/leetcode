package cn.tiny77.algorithm;

public class DataUtils {

    public static int[] toIntArray(String str) {
        str = str.replace("[", "");
        str = str.replace("]", "");
        String[] strings = str.split(",");
        int[] result = new int[strings.length];
        int i = 0;
        for (String string : strings) {
            result[i ++ ] = Integer.parseInt(string.trim());
        }
        return result;
    }

}
