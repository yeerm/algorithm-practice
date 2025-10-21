package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Programmers - 데이터 분석 (Lv.1)
 *
 * [문제]
 * AI 엔지니어인 현식이는 데이터를 분석하는 작업을 진행하고 있습니다.
 * 데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)",
 * "현재 수량(remain)"]으로 구성되어 있으며 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.
 *
 * 정렬한 데이터들이 담긴 이차원 정수 리스트 data와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext,
 * 뽑아낼 정보의 기준값을 나타내는 정수 val_ext, 정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.
 *
 * data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후,
 * sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요.
 * 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.
 *
 * [풀이]
 * - ext는 code, date, maximum, remain
 * - code = 0, date = 1, maximum = 2, remain = 3
 *
 */
public class DataAnalysis {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int ext_val = 20300501;
        String sort_by = "remain";
        System.out.println(solution(data, ext, ext_val, sort_by));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>();

        int idx = ext.equals("code") ? 0 : ext.equals("date") ? 1 : ext.equals("maximum") ? 2 : 3;
        int sortIdx = sort_by.equals("code") ? 0 : sort_by.equals("date") ? 1 : sort_by.equals("maximum") ? 2 : 3;

        for(int i=0; i<data.length; i++) {
            if(data[i][idx] < val_ext) {
                list.add(data[i]);
            }
        }

        list.sort(Comparator.comparing((int[] arr) -> arr[sortIdx]));

        answer = list.toArray(new int[list.size()][]);

        return answer;
    }

    public static int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<String> strList = List.of("code","date", "maximum", "remain");

        int etxIdx = strList.indexOf(ext);
        int sortIdx = strList.indexOf(sort_by);

        answer = Arrays.stream(data)
                .filter(d -> d[etxIdx] < val_ext)
                .sorted(Comparator.comparingInt(n -> n[sortIdx]))
                .toArray(int[][]:: new);

        return answer;
    }

    }
}
