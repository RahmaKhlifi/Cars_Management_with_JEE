package Controller;


import Model.Product;
import Model.User;
import Model.Offer;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private static List<Product> products;
    private static List<Offer> offers;

    static {
        products = new ArrayList<>();
        offers = new ArrayList<>();

        User user1 = UserController.getUserByUsername("user1");
        User user2 = UserController.getUserByUsername("user2");

        products.add(new Product("BMW I8", "https://www.bmwusa.com/content/dam/bmwusa/common/retired-vehicles/i8/mobile/375_Retired_Vehicles_i8_04-v2.jpg", 148.495 , user1));
        products.add(new Product("BMW m4", "https://media.ed.edmunds-media.com/bmw/m4/2022/oem/2022_bmw_m4_coupe_competition_fq_oem_1_1600.jpg", 79.095, user2));
        products.add(new Product("BMW X7", "https://media.ed.edmunds-media.com/bmw/x7/2023/oem/2023_bmw_x7_4dr-suv_m60i_fq_oem_1_1280.jpg", 150.395, user1));
    }

    public static List<Product> getAllProducts() {
        return products;
    }

    public static Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public static void placeBid(User bidder, Product product, double bidAmount) {
        Offer offer = new Offer(bidder, product, bidAmount);
       

        
        if (bidAmount > product.getCost()) {
            product.setCost(bidAmount);
            offers.add(offer);
        }
   }
    public static List<Offer> getOffersForProduct(Product product) {
        List<Offer> productOffers = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getProduct().equals(product)) {
                productOffers.add(offer);
            }
        }
        return productOffers;
    }

    public static List<Offer> getOffersByUser(User user) {
        List<Offer> userOffers = new ArrayList<>();
        for (Offer offer : offers) {
            if (offer.getBidder().equals(user)) {
                userOffers.add(offer);
            }
        }
        return userOffers;
    }
}