package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.*;

public class ShoppingCart {
	
	private List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }
    
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }
    
    // 아이템 제거
    public boolean removeItem(String title) {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getTitle().equals(title)) {

                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }

        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false;
    }
    
    // 전체 가격 계산
    public int calculateTotalPrice() {

        int total = 0;

        for (Publication item : items) {
            total += item.getPrice();
        }

        return total;
    }
    
    // 할인가 계산
    public int calculateDiscountedPrice() {

        int total = 0;

        for (Publication item : items) {

            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;

            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85;

            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;

            } else {
                total += item.getPrice();
            }
        }

        return total;
    }
    
    // 타입별 통계
    public void printStatistics() {

        int magazine = 0;
        int novel = 0;
        int ref = 0;

        for (Publication item : items) {

            if (item instanceof Magazine) magazine++;
            else if (item instanceof Novel) novel++;
            else if (item instanceof ReferenceBook) ref++;
        }

        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazine + "권");
        System.out.println("소설: " + novel + "권");
        System.out.println("참고서: " + ref + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }

}
