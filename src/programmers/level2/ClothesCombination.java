package programmers.level2;

//코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.

//예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
// 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.

//조건
//코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다.
// 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
// 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
// 코니는 하루에 최소 한 개의 의상은 입습니다.

//코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

import java.util.HashMap;
import java.util.Map;

public class ClothesCombination {
    public static int solution(String[][] clothes) {
        int answer = 1;

        // 종류별로 구분해서 몇개씩 있는지 저장
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], (clothesMap.getOrDefault(clothe[1], 0 ) + 1));
        }

        for (String key : clothesMap.keySet()) {
            System.out.println("key: " + key + ", value: " + clothesMap.get(key));
            // 코니는 하루에 최소 한 개의 의상은 입습니다.
            // 그렇다면 다른 종류의 옷은 걸치지 않을 수 있으므로, 안입는 경우 1가지 더해줌
            answer *= (clothesMap.get(key) + 1);
        }

        // 지금 계산에서 주어진 clothes를 아예 안입는 경우가 1번 포함되어 있고 그건 경우의 수애서 제외해야함

        return answer - 1;
    }

    public static void main(String[] args) {
        // yellow_hat
        // green_turban
        // blue_sun

        // yellow_hat, blue
        // green_turban, blue

        String[][] clothes1 = {{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}};
        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
    }
}
