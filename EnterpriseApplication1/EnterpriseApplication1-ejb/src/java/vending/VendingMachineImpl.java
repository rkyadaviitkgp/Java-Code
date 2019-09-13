/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author rajeshkumar.yadav
 */
public class VendingMachineImpl implements VendingMachine {
    
    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;
    
    
    public VendingMachineImpl()
    {
        initialize();
    }
    
    private void initialize()
    {
        for(Coin c : Coin.values())
        {
            cashInventory.put(c, 5);
        }
        for(Item i: Item.values())
        {
            itemInventory.put(i, 5);
        }
    }
    
    public long selectItemAndGetPrice(Item item)
    {
        if(itemInventory.hasItem(item))
        {
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Item is sold out, please select a differnt Item");
    }
    
    public void insertCoin(Coin c)
    {
        currentBalance = currentBalance + c.getDenomination();
        cashInventory.add(c);
    }
    
    public Bucket<Item, List<Coin>> collectItemAndChange()
    {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);
    }
    
    private List<Coin> collectChange()
    {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }
    
    private void updateCashInventory(List<Coin> change)
    {
        for(Coin c: change)
        {
            cashInventory.deduct(c);
        }
    }
    
    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPaid())
        {
            if(hasSufficientChange())
            {
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Sufficinet change is not avialable in the system");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("price not full paid, remaining: ", remainingBalance);
    }
    
    private boolean isFullPaid()
    {
        if(currentBalance >= currentItem.getPrice())
            return true;
        else
            return false;
    }
    
    private boolean hasSufficientChange()
    {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }
    
    private boolean hasSufficientChangeForAmount(long amount)
    {
        boolean hasChange = true;
        
        try{
            getChange(amount);
        }catch(NotSufficientChangeException nsce)
        {
            hasChange = false;
        }
        
        return hasChange;
    }
    
    private List<Coin> getChange(long amount) throws NotSufficientChangeException
    {
        List<Coin> changes = Collections.EMPTY_LIST;
        Inventory<Coin> tempCashInventory = new Inventory<Coin>(cashInventory);
        //Map<Coin, Integer> tempCashInventory = new HashMap<Coin, Integer>(cashInventory.getInventory());
        if(amount > 0)
        {
            changes = new ArrayList<Coin>();
            long balance = amount;
            while(balance>0)
            {
                if(balance >= Coin.QUARTER.getDenomination() && tempCashInventory.getQuantity(Coin.QUARTER) > 0)
                {
                    balance = balance - Coin.QUARTER.getDenomination();
                    changes.add(Coin.QUARTER);
                    tempCashInventory.deduct(Coin.QUARTER);
                    continue;
                }else if(balance >= Coin.DIME.getDenomination() && tempCashInventory.getQuantity(Coin.DIME) > 0 )
                {
                    balance = balance - Coin.DIME.getDenomination();
                    changes.add(Coin.DIME);
                    tempCashInventory.deduct(Coin.DIME);
                    continue;
                }else if(balance >= Coin.NICKLE.getDenomination() && tempCashInventory.getQuantity(Coin.NICKLE) > 0)
                {
                    balance = balance - Coin.NICKLE.getDenomination();
                    changes.add(Coin.NICKLE);
                    tempCashInventory.deduct(Coin.NICKLE);
                    continue;
                }else if(balance >= Coin.PENY.getDenomination() && tempCashInventory.getQuantity(Coin.PENY) > 0)
                {
                    balance = balance - Coin.PENY.getDenomination();
                    changes.add(Coin.PENY);
                    tempCashInventory.deduct(Coin.PENY);
                    continue;
                }else{
                    throw new NotSufficientChangeException("Sufficient change is not available, please try different item");
                }
            }
        }
        
        return changes;
    }
    
    public List<Coin> refund()
    {
        List<Coin> change = getChange(currentBalance);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }
    
    public void reset()
    {
        cashInventory.clear();
        itemInventory.clear();
        currentBalance = 0;
        currentItem = null;
        totalSales = 0;
    }

    public long getTotalSales() {
        return totalSales;
    }
    
    public void printStats()
    {
        System.out.println("Total Sales : " + totalSales);
        System.out.println("CashInventory :" + cashInventory);
        System.out.println("ItemInventory :" + itemInventory);
    }
    
}
