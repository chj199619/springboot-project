package org.lanqiao.project.service;

import org.lanqiao.project.mapper.CartMapper;
import org.lanqiao.project.pojo.Cart;
import org.lanqiao.project.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements CartMapper {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> selectAllCart() {
        List<Cart> carts = cartMapper.selectAllCart();
        return carts;
    }

    @Override
    public List<Cart> selectAll(int u_id ,int p_id) {
        List<Cart> cartList = cartMapper.selectAll(u_id,p_id);
        return cartList;
    }

    @Override
    public List<Cart> selectWish(int u_id) {
        List<Cart> cartList = cartMapper.selectWish(u_id);
        return cartList;
    }

    @Override
    public Cart selectCartById(int g_id, int u_id) {
        Cart cart =  cartMapper.selectCartById(g_id,u_id);
        return cart;
    }

    @Override
    public void add(Cart cart)
    {

        cartMapper.add(cart);
    }

    @Override
    public void house(Cart cart) {
        cartMapper.house(cart);
    }

    @Override
    public void upnum(int num, int id) {
        cartMapper.upnum(num,id);
    }

    @Override
    public void del(int gid,int uid) {
        cartMapper.del(gid,uid);
    }

    @Override
    public void delWish(int gid,int uid) {
        cartMapper.delWish(gid,uid);
    }


    @Override
    public void psaddPaper(Paper paper) {
        cartMapper.psaddPaper(paper);
    }

    @Override
    public void uppid( int p_id, int id) {
        cartMapper.uppid(p_id,id);
    }

    @Override
    public void pansUpdate(int pid, String cond,int uid) {
        cartMapper.pansUpdate(pid,cond,uid);
    }
    @Override
    public String selectUserAddress(int u_id) {
        String address = cartMapper.selectUserAddress(u_id);
        System.out.println(address);
        return address;
    }
}
