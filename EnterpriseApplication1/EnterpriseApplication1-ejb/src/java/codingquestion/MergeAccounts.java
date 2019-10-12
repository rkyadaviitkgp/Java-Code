/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav
 */

class AccountInfo{
    
    String name;
    List<String> accountMailIdList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAccountMailIdList() {
        return accountMailIdList;
    }

    public void setAccountMailIdList(List<String> accountMailIdList) {
        this.accountMailIdList = accountMailIdList;
    }

    public AccountInfo(List<String> accountMailIdList) {
        this.name = accountMailIdList.get(0);
        this.accountMailIdList = new ArrayList<>(accountMailIdList);
        this.accountMailIdList.remove(0);
    }
    
    public List<String> getAccountInArrayForm(){
        
        List<String> list = new ArrayList<String>(this.accountMailIdList);
        list.add(0, name);
        return  list;
        
    }
    
    public void addToList(String mailId){
        this.accountMailIdList.add(mailId);
    }
    
}
public class MergeAccounts {
    
    Map<String, AccountInfo> map;
    List<AccountInfo> accountInfoList1;

    public MergeAccounts() {
        this.map = new HashMap<>();
        accountInfoList1 = new ArrayList<>();
    }
    
    public void addListInMap(List<String> accList, AccountInfo acc){
        
        
        if(acc == null)
        {
            acc = new AccountInfo(accList);
            accountInfoList1.add(acc);
        }
        
        for(int i = 1; i<accList.size(); i++){
            if(map.get(accList.get(i)) == null)
            {
                acc.addToList(accList.get(i));
                map.put(accList.get(i), acc);
            }
            
        }
        
    }
    
    
   public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        for(int ind = 0; ind < accounts.size(); ind++){
            AccountInfo accountInstance = null;
            for(int i = 1; i<accounts.get(ind).size(); i++){
                if(map.get(accounts.get(ind).get(i)) != null){
                    accountInstance = map.get(accounts.get(ind).get(i));
                    break;
                }
            }
            addListInMap(accounts.get(ind), accountInstance);
        }
        List<List<String>> ans = new ArrayList<List<String>>();
         for(AccountInfo temp: accountInfoList1){
            List<String> anspart = temp.getAccountInArrayForm();
            String name = anspart.get(0);
            anspart.remove(0);
             Collections.sort(anspart);
             anspart.add(0, name);
            ans.add(anspart);
        }
        return  ans;
    }
    
    
    public static void main(String[] args) {
        
    }
    
}
