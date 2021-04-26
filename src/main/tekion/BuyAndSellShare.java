package main.tekion;

import java.util.*;


//input_list = [
//        "p1 sell s1 1500 200",
//        "p2 buy s2 900 500",
//        "p3 buy s1 600 250",
//        "p4 buy s1 1200 270",
//        "p5 sell s3 300	800",
//        "p6	sell s3 100	750",
//        "p7 buy s3 500 900",
//        "p20 sell s4 200 100",
//        "p21 sell s4 200 150",
//        "p22 buy s4 200 300",
//        "p10 sell s2 1000 400"
//        ]


//person type stock qty	price
//
//        p1	sell	s1	1500	200
//        p2	buy		s2	900		500
//        p3	buy		s1	600		250
//        p4	buy		s1	1200	270
//
//        p5	sell	s3 	300		800
//        p6	sell	s3 	100		750
//        p7  buy     s3  500     900
//
//        p20 sell 	s4	200		100
//        p21 sell 	s4	200		150
//        p22 buy     s4  200     300
//
//        p23	buy		s2	900		500
//        p10	sell	s2	1000	400
//
//        Trades
//        p3:s1:600:200
//        p4:s1:900:200
//
//        p7:s3:100:750
//        p7:s3:300:800
//
//        p22:s4:200:100
//
//        p2:s2:900:400
//        p23:s2:100:400


public class BuyAndSellShare {

    class ShareOperation {
        String person;
        String operation;
        String shareName;
        int quantity;
        int price;

        public ShareOperation(String person, String operation, String shareName, int quantity, int price) {
            this.person = person;
            this.operation = operation;
            this.shareName = shareName;
            this.quantity = quantity;
            this.price = price;
        }
    }

    class ShareBuyAndSellList {
        PriorityQueue<ShareOperation> buy;
        PriorityQueue<ShareOperation> sell;
        List<ShareOperation> buyList = new LinkedList<>();
        List<ShareOperation> sellList = new LinkedList<>();

        public ShareBuyAndSellList() {
            this.buy = new PriorityQueue<>((a, b) -> a.price - b.price);
            this.sell = new PriorityQueue<ShareOperation>();
        }
    }

    public void buyAndSell(List<ShareOperation> list) {

        if (list.size() == 0) return;

        Map<String, ShareBuyAndSellList> orderMap = new HashMap<>();

        for (ShareOperation shareOperation : list) {
            ShareBuyAndSellList shareBuyAndSellList = orderMap.getOrDefault(shareOperation.shareName, new ShareBuyAndSellList());

            if (shareOperation.operation.equalsIgnoreCase("sell")) {
                if (shareBuyAndSellList.buy.size() > 0 && shareBuyAndSellList.buy.peek().price >= shareOperation.price) {
                    ShareOperation opt = shareBuyAndSellList.buy.peek();
                    if (opt.quantity >= shareOperation.quantity) {
                        if (opt.quantity == shareOperation.quantity) shareBuyAndSellList.buy.remove(opt);
                        else opt.quantity = opt.quantity - shareOperation.quantity;
                    } else {
                        shareBuyAndSellList.buy.remove(opt);
                        shareOperation.quantity = shareOperation.quantity - opt.quantity;
                        shareBuyAndSellList.sell.add(shareOperation);
                        shareBuyAndSellList.sellList.add(shareOperation);
                        orderMap.put(shareOperation.shareName, shareBuyAndSellList);
                    }
                    System.out.println(" Person " + shareOperation.person + " quantity " + shareOperation.quantity + " price " + opt.price);
                } else {
                    shareBuyAndSellList.sellList.add(shareOperation);
                    shareBuyAndSellList.sell.add(shareOperation);
                    orderMap.put(shareOperation.shareName, shareBuyAndSellList);
                }
            } else {
                if (shareBuyAndSellList.buy.size() > 0 && shareBuyAndSellList.sell.peek().price <= shareOperation.price) {
                    ShareOperation opt = shareBuyAndSellList.sell.peek();
                    if (opt.quantity >= shareOperation.quantity) {
                        if (opt.quantity == shareOperation.quantity) shareBuyAndSellList.sell.remove(opt);
                        else opt.quantity = opt.quantity - shareOperation.quantity;
                    } else {
                        shareBuyAndSellList.sell.remove(opt);
                        shareOperation.quantity = shareOperation.quantity - opt.quantity;
                        shareBuyAndSellList.buy.add(shareOperation);
                        shareBuyAndSellList.buyList.add(shareOperation);
                        orderMap.put(shareOperation.shareName, shareBuyAndSellList);
                    }
                    System.out.println(" Person " + shareOperation.person + " quantity " + shareOperation.quantity + " price " + opt.price);
                } else {
                    shareBuyAndSellList.buyList.add(shareOperation);
                    shareBuyAndSellList.buy.add(shareOperation);
                    orderMap.put(shareOperation.shareName, shareBuyAndSellList);
                }
            }
        }
    }

}
