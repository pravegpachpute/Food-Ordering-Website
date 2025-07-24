package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.model.Cart;
import com.floobyte.franchise.model.CartItem;
import com.floobyte.franchise.model.Food;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.repository.CartItemRepository;
import com.floobyte.franchise.repository.CartRepository;
import com.floobyte.franchise.request.AddCartItemRequest;
import com.floobyte.franchise.service.CartService;
import com.floobyte.franchise.service.FoodService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private FoodService foodService;

    @Override
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Food food = foodService.findFoodById(req.getFoodId());

        Cart cart = cartRepository.findByCustomerId(user.getId());
        for(CartItem cartItem : cart.getItems()){
            if(cartItem.getFood().equals(food)){
                int newQuantity = cartItem.getQuantity()+ req.getQuantity();
                return updateCartItemQuantity(cartItem.getId(), newQuantity);
            }
        }
        CartItem newCartItem = new CartItem();
        newCartItem.setFood(food);
        newCartItem.setCart(cart);
        newCartItem.setIngredients(req.getIngredients());
        newCartItem.setQuantity(req.getQuantity());
        newCartItem.setTotlePrice(req.getQuantity()* food.getPrice());

        CartItem saveCartItem = cartItemRepository.save(newCartItem);
        cart.getItems().add(saveCartItem);
        return saveCartItem;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {
        Optional<CartItem> optionalCartItem= cartItemRepository.findById(cartItemId);
        if(optionalCartItem.isEmpty()){
            throw new Exception("Cart item not fond...");
        }
        CartItem item = optionalCartItem.get();
        item.setQuantity(quantity);
        item.setTotlePrice(item.getFood().getPrice()*quantity); //500*5=500
        return cartItemRepository.save(item);
    }

    @Override
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);

        Cart cart = cartRepository.findByCustomerId(user.getId());

        Optional<CartItem> optionalCartItem= cartItemRepository.findById(cartItemId);
        if(optionalCartItem.isEmpty()){
            throw new Exception("Cart item not fond...");
        }
        CartItem item = optionalCartItem.get();
        cart.getItems().remove(item);

        return cartRepository.save(cart);
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {
        Long totle = 0L;
        for(CartItem cartItem : cart.getItems()){
            totle += cartItem.getFood().getPrice() * cartItem.getQuantity();
        }
        return totle;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isEmpty()){
            throw new Exception("Cart not found with id" + id);
        }
        return optionalCart.get();
    }

    @Override
    public Cart findCartByUserId(Long userId) throws Exception {
//        User user = userService.findByUserJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(userId);
        cart.setTotale(calculateCartTotals(cart));
        return  cart;
    }

    @Override
    public Cart clearCart(Long userId) throws Exception {
//        User user = userService.findByUserJwtToken(jwt);
        Cart cart = findCartByUserId(userId);
        cart.getItems().clear();
        return cartRepository.save(cart);
    }
}
