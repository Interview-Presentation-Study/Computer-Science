package store.service;

import store.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private final Map<String, Product> inventory;
    public Service(Map<String, Product> init){
        this.inventory = new HashMap<>(init);
    }
    // 구매 가능한 제품 리스트
    public List<String> getAvailableProducts(){
        List<String> produceList = new ArrayList<>();
        for(Product product: inventory.values()){
            produceList.add(product.toString());
        }
        return produceList;
    }
    // 구매
    public String processPurchase(String input){
        validateInput(input);
        String[] items = input.replaceAll("[\\\\[\\\\]]","").split(",");
        List<String> receipt = new ArrayList<>();

        int totalAmount = 0;
        int discount = 0;

        for(String item: items){
            String[] details = item.trim().split("-");
            String productName = details[0];
            int quantity = Integer.parseInt(details[1]);

            Product product = inventory.get(productName);
            if(product==null || product.getStock()<quantity) throw new IllegalArgumentException("재고가 부족하거나 존재하지 않는 상품입니다.");

            int subTotal = product.getPrice() * quantity;
            int promoDiscount = calculatePromotion(product, quantity);

            product.reduceStock(quantity);
            receipt.add(productName+" "+quantity+"개:"+(subTotal-promoDiscount)+"원");

            totalAmount += subTotal;
            discount += promoDiscount;
        }
        int membershipDiscount = applyMembershipDiscount(totalAmount-discount);
        return buildReceipt(receipt, totalAmount, discount, membershipDiscount);
    }
    // 프로모션 계산
    private int calculatePromotion(Product product, int quantity){
        int promoDiscount = 0;
        // 프로모션 정보
        int promoType = product.getPromotionType();
        int promoStock = product.getPromotionStock();
        if(promoType==0 || promoStock<0) return promoDiscount;

        // 프로모션 적용 가능한 수량 계산
        int possibleQuantity = 0;
        if(promoType==1) possibleQuantity = Math.min(quantity/2, promoStock); // 1+1 프로모션
        else if(promoType==2) possibleQuantity = Math.min(quantity/3, promoStock); // 2+1 프로모션

        // 프로모션 적용 재고 차감
        int promoUsedStock = possibleQuantity * (promoType==1? 2: 3);
        product.reducePromotionStock(Math.min(promoUsedStock, promoStock));
        // 할인 계산
        promoDiscount = possibleQuantity * product.getPrice();
        // 일반 재고로 추가 처리(프로모션 재고 부족 시)
        if(promoUsedStock<quantity){
            int remainingQuantity = quantity - promoUsedStock;
            if(remainingQuantity>0) System.out.println("프로모션 재고가 부족하여"+remainingQuantity+"개는 정가로 결제됩니다.");
        }
        return promoDiscount;
    }
    private int applyMembershipDiscount(int amount){
        return Math.min(8000, amount*30/100);
    }
    // 입력값 검증
    private void validateInput(String input) {
        if (!input.matches("(\\[\\w+-\\d+],?\\s?)+")) {
            throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해주세요.");
        }
    }

    // 영수증
    private String buildReceipt(List<String> items,int total, int discount, int membership){
        StringBuilder receipt = new StringBuilder();
        items.forEach(item -> receipt.append(item).append("\n"));
        receipt.append("총 구매액: ").append(total).append("원\n");
        receipt.append("행사 할인: ").append(discount).append("원\n");
        receipt.append("멤버십 할인:-").append(membership).append("원\n");
        receipt.append("내실 돈: ").append(total-discount-membership).append("원\n");
        return receipt.toString();
    }
}
