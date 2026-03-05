package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.*;

public class StatisticsAnalyzer {

	// 출판물 타입 확인
    private String getPublicationType(Publication pub) {

        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";

        return "기타";
    }

    // 타입별 평균 가격
    
    // Map<key타입, value타입>
    // Map → 인터페이스 , HashMap → 실제 구현 클래스
    public Map<String, Double> calculateAveragePriceByType(Publication[] pubs) {

        Map<String, Integer> total = new HashMap<>(); // 타입별 총 가격
        Map<String, Integer> count = new HashMap<>(); // 타입별 개수

        for (Publication p : pubs) {

            String type = getPublicationType(p);
            
            // map.getOrDefault(key, 기본값) -> key가 있으면 값 반환하고 없으면 기본값 반환
            total.put(type, total.getOrDefault(type, 0) + p.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avg = new HashMap<>();

        for (String key : total.keySet()) {

            avg.put(key, total.get(key) / (double) count.get(key));
        }

        return avg;
    }

    // 타입별 비율
    public Map<String, Double> calculatePublicationDistribution(Publication[] pubs) {

        Map<String, Integer> count = new HashMap<>();

        for (Publication p : pubs) {

            String type = getPublicationType(p);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> result = new HashMap<>();

        for (String key : count.keySet()) {

            result.put(key, count.get(key) * 100.0 / pubs.length);
        }

        return result;
    }

    // 특정 연도 출판 비율
    public double calculatePublicationRatioByYear(Publication[] pubs, String year) {

        int count = 0;

        for (Publication p : pubs) {

            if (p.getPublishDate().startsWith(year)) {
                count++;
            }
        }

        return count * 100.0 / pubs.length;
    }

    // 통계 출력
    public void printStatistics(Publication[] pubs) {

        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("\n===== 통계 분석 =====");

        Map<String, Double> avg = calculateAveragePriceByType(pubs);

        System.out.println("타입별 평균 가격");
        avg.forEach((k,v)-> System.out.println(k + " : " + df.format(v)));

        Map<String, Double> dist = calculatePublicationDistribution(pubs);

        System.out.println("\n출판물 유형 분포");
        dist.forEach((k,v)-> System.out.println(k + " : " + df.format(v) + "%"));

        double ratio = calculatePublicationRatioByYear(pubs,"2007");

        System.out.println("\n2007년 출판 비율 : " + df.format(ratio) + "%");
    }
}