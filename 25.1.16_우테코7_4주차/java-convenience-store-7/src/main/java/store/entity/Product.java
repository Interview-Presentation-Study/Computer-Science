package store.entity;
public class Product {
    private final String name;
    private final int price;
    private int stock;
    private int promotionType;
    private int promotionStock;
    // 기본적으로 프로모션 없음
    public Product(String name, int price, int stock) {
        this(name, price, stock, 0,0);
    }

    public Product(String name, int price, int stock, int promotionType, int promotionStock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.promotionType = promotionType;
        this.promotionStock = promotionStock;
    }

    public int getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }

    public int getPromotionType() {
        return promotionType;
    }

    public int getPromotionStock() {
        return promotionStock;
    }
    // 재고 차감
    public void reduceStock(int quantity){
        if(stock<quantity) throw new IllegalArgumentException("재고가 부족합니다.");
        stock -= quantity;
    }
    // 프로모션 재고 차감
    public void reducePromotionStock(int quantity){
        if(promotionStock<quantity) throw new IllegalArgumentException("프로모션 재고가 부족합니다.");
        promotionStock -= quantity;
    }

    public String toString(){
        return name+" "+price+"원"+stock+"개(프로모션 재고: "+promotionStock+")";
    }
}
