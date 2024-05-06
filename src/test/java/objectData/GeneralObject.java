package objectData;

import java.util.ArrayList;
import java.util.List;

public class GeneralObject {

    public List<String> getPreparedValue(String text) {
        List<String> result = new ArrayList<>();
        String[] valueSplit = text.split(",");
        for (int i = 0; i < valueSplit.length; i++) {
            result.add(valueSplit[i]);
        }
        return result;
    }
}
