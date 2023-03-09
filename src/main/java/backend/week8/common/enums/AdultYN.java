package backend.week8.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Getter
public enum AdultYN {
    NO("0", "NO"),
    YES("1", "YES");

    private static final String NOT_FOUND_ELEMENT = "존재하지 않는 요소 입니다.";
    private String flag;
    private String word;

    public static String findWordByFlag(String flag) {
        return Arrays.stream(AdultYN.values())
                .filter(element -> element.flag.equals(flag))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_ELEMENT))
                .getWord();
    }
}
