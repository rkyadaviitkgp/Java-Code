/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdesign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author rajeshkumar.yadav
 */
public class BattleShipDesign {

    /**
     * @param args the command line arguments
     */
    
    private GameHandler gh;

    public BattleShipDesign(String name1, String name2, ArrayList<ArrayList<Integer>> u1Xaxis, ArrayList<ArrayList<Integer>>u1Yaxis, ArrayList<ArrayList<Integer>> u2Xaxis, ArrayList<ArrayList<Integer>>u2Yaxis) {
        this.gh = new GameHandler(name1, name2, u1Xaxis, u1Yaxis, u2Xaxis, u2Yaxis);
    }

    public GameHandler getGh() {
        return gh;
    }
    
    
    
    public static void TakeInput(ArrayList<ArrayList<Integer>> u1Xaxis, ArrayList<ArrayList<Integer>>u1Yaxis, ArrayList<ArrayList<Integer>> u2Xaxis, ArrayList<ArrayList<Integer>>u2Yaxis){
        
        int[] arru1x1 = new int[]{1,1,1,1,1};
        int[] arru1y1 = new int[]{1,2,3,4,5};
        ArrayList<Integer> inx = new ArrayList<>();
        ArrayList<Integer> iny = new ArrayList<>();
        for(int i=0; i<arru1x1.length; i++)
            inx.add(arru1x1[i]);
        for(int i=0; i<arru1y1.length; i++)
            iny.add(arru1y1[i]);
        u1Xaxis.add(inx);
        u1Yaxis.add(iny);
        
        
        
        arru1x1 = new int[]{2,2,2,2};
        arru1y1 = new int[]{1,2,3,4};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru1x1.length; i++)
            inx.add(arru1x1[i]);
        for(int i=0; i<arru1y1.length; i++)
            iny.add(arru1y1[i]);
        
        u1Xaxis.add(inx);
        u1Yaxis.add(iny);      
        arru1x1 = new int[]{3,3,3};
        arru1y1 = new int[]{1,2,3};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru1x1.length; i++)
            inx.add(arru1x1[i]);
        for(int i=0; i<arru1y1.length; i++)
            iny.add(arru1y1[i]);
        u1Xaxis.add(inx);
        u1Yaxis.add(iny);  
        
        arru1x1 = new int[]{4,4,4};
        arru1y1 = new int[]{1,2,3};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru1x1.length; i++)
            inx.add(arru1x1[i]);
        for(int i=0; i<arru1y1.length; i++)
            iny.add(arru1y1[i]);
        u1Xaxis.add(inx);
        u1Yaxis.add(iny);  
        
        arru1x1 = new int[]{5,5};
        arru1y1 = new int[]{1,2};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru1x1.length; i++)
            inx.add(arru1x1[i]);
        for(int i=0; i<arru1y1.length; i++)
            iny.add(arru1y1[i]);
        u1Xaxis.add(inx);
        u1Yaxis.add(iny);  
        
        int[] arru2x1 = new int[]{1,1,1,1,1};
        int[] arru2y1 = new int[]{1,2,3,4,5};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru2x1.length; i++)
            inx.add(arru2x1[i]);
        for(int i=0; i<arru2y1.length; i++)
            iny.add(arru2y1[i]);
        u2Xaxis.add(inx);
        u2Yaxis.add(iny);
        
        arru2x1 = new int[]{2,2,2,2};
        arru2y1 = new int[]{1,2,3,4};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru2x1.length; i++)
            inx.add(arru2x1[i]);
        for(int i=0; i<arru2y1.length; i++)
            iny.add(arru2y1[i]);
        u2Xaxis.add(inx);
        u2Yaxis.add(iny);
//        
        arru2x1 = new int[]{3,3,3};
        arru2y1 = new int[]{1,2,3};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru2x1.length; i++)
            inx.add(arru2x1[i]);
        for(int i=0; i<arru2y1.length; i++)
            iny.add(arru2y1[i]);
        u2Xaxis.add(inx);
        u2Yaxis.add(iny);
        arru2x1 = new int[]{4,4,4};
        arru2y1 = new int[]{1,2,3};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru2x1.length; i++)
            inx.add(arru2x1[i]);
        for(int i=0; i<arru2y1.length; i++)
            iny.add(arru2y1[i]);
        u2Xaxis.add(inx);
        u2Yaxis.add(iny);
        arru2x1 = new int[]{5,5};
        arru2y1 = new int[]{1,2};
        inx = new ArrayList<>();
        iny = new ArrayList<>();
        for(int i=0; i<arru2x1.length; i++)
            inx.add(arru2x1[i]);
        for(int i=0; i<arru2y1.length; i++)
            iny.add(arru2y1[i]);
        u2Xaxis.add(inx);
        u2Yaxis.add(iny);
        
        
    }
    
    
    public static void main(String[] args) throws IOException {
        
        // TODO code application logic here
        ArrayList<ArrayList<Integer>> u1Xaxis = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> u1Yaxis = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> u2Xaxis = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> u2Yaxis = new ArrayList<ArrayList<Integer>>();
        
        TakeInput(u1Xaxis, u1Yaxis, u2Xaxis, u2Yaxis);
        
        BattleShipDesign bsd = new BattleShipDesign("User1", "User2", u1Xaxis, u1Yaxis, u2Xaxis, u2Yaxis);
        
        int turn  = 2;
        
        while(bsd.gh.DoesUserWon(turn) == false){
            if(turn == 1)
                turn = 2;
            else
                turn = 1;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String input  = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bsd.gh.shootTarget(turn, x, y);
        }
        if(turn == 1)
            System.out.println(bsd.getGh().getU2().getName() + " lost");
        else
            System.out.println(bsd.getGh().getU1().getName() + " lost ");
        
    }
    
}
