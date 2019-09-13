

   
  import java.util.*;

  /*
   * To change this license header, choose License Headers in Project Properties.
   * To change this template file, choose Tools | Templates
   * and open the template in the editor.
   */

  /**
   *
   * @author rajeshkumar.yadav
   */

  
  class Tweet{
      
      int tweetId;
      int timestamp;
      
      public Tweet(int id, int tm)
      {
          tweetId = id;
          timestamp = tm;
      }

      public int getTweetId() {
          return tweetId;
      }

      public void setTweetId(int tweetId) {
          this.tweetId = tweetId;
      }

      public int getTimestamp() {
          return timestamp;
      }

      public void setTimestamp(int timestamp) {
          this.timestamp = timestamp;
      }
      
      
  }

  class User{
      
      int userId;
      List<User> follow;
      Tweet userTweet[];
      int start_ind;
      int len;

      public int getUserId() {
          return userId;
      }

      public void setUserId(int userId) {
          this.userId = userId;
      }

      public List<User> getFollow() {
          return follow;
      }

      public void setFollow(List<User> follow) {
          this.follow = follow;
      }

      public Tweet[] getUserTweet() {
          return userTweet;
      }

      public void setUserTweet(Tweet[] userTweet) {
          this.userTweet = userTweet;
      }

      public int getStart_ind() {
          return start_ind;
      }

      public void setStart_ind(int start_ind) {
          this.start_ind = start_ind;
      }

      public int getLen() {
          return len;
      }

      public void setLen(int len) {
          this.len = len;
      }
      
      
      public User(int uid)
      {
          this.userId = uid;
          follow = new ArrayList<User>();
          userTweet = new Tweet[10];
          start_ind = -1;
          len = 0;
      }
      
      public void setTweet(Tweet t)
      {
          userTweet[(start_ind + 1) % 10 ] = t;
          start_ind = (start_ind + 1)%10;
          len++;
      }
      
      public void setFollow(User u1)
      {
          if(!follow.contains(u1))
          follow.add(u1);
      }
      
      public void unFollow(User u1)
      {
          follow.remove(u1);
      }
    
  }


  public class NewTwitter {

      /** Initialize your data structure here. */
      HashMap<Integer, User> alluser;
      public static int counter = 0;
      public NewTwitter() {
          
           alluser = new HashMap<Integer, User>();
          
      }
      
      
      public static void main(String args[])
    {
        NewTwitter tw = new NewTwitter();
//        tw.postTweet(1, 5);
////        tw.getNewsFeed(1);
////        tw.follow(1, 2);
////        tw.postTweet(2, 6);
////        tw.getNewsFeed(1);
////        tw.unfollow(1, 2);
////        tw.getNewsFeed(1);
//tw.postTweet(1, 6);
//tw.postTweet(1, 7);
//tw.postTweet(1, 8);
////tw.getNewsFeed(1);
//tw.postTweet(1, 9);
//tw.postTweet(1, 10);
//tw.postTweet(1, 1);
//tw.postTweet(1, 2);
//tw.postTweet(1, 3);
//tw.postTweet(1, 4);
//tw.postTweet(1, 51);
//tw.getNewsFeed(1);

/*
["Twitter","postTweet","follow","getNewsFeed"]
[   [],      [1,5],      [1,1],      [1]]
*/

tw.postTweet(1, 5);
tw.follow(1, 1);
System.out.println(tw.getNewsFeed(1));;
        
    }
      
       /** Compose a new tweet. */
      public void postTweet(int userId, int tweetId) {
          
          User u1 = alluser.get(userId);
          
          if(u1 == null)
          {
              u1 = new User(userId);
              alluser.put(userId, u1);
          }
          
          Tweet t = new Tweet(tweetId, counter++);
          u1.setTweet(t);
          
      }
      
      /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
      public List<Integer> getNewsFeed(int userId) {
          
          List<Integer> newsFeed =  new ArrayList<>();
          User u1 = alluser.get(userId);
          
          if( u1 == null)
          {
              return newsFeed;
          }
          
          int len = u1.getFollow().size();
          
          int[] index = new int[len+1];
          int[] lenth = new int[len+1];
          
          List<User> newlist = new ArrayList<>(u1.getFollow());
          newlist.add(u1);
          
          int i = 0;
          for(User u : newlist)
          {
              index[i] = u.getStart_ind();
              lenth[i++] = u.getLen();
          }
          
          int minind;
          for(i=0;i<10;i++)
          {
              minind = -1;
              
              for(int j=0;j<newlist.size();j++)
              {
                  if(lenth[j] > 0)
                  {
                      minind = j;
                      break;
                  }
              }
              
              if(minind == -1)
                  break;
              
              for(int j=0; j<newlist.size(); j++)
              {
                  User nu = newlist.get(j);
                  if(lenth[j] > 0)
                  {
                      if(nu.getUserTweet()[(index[j] + 10 )%10].getTimestamp() > newlist.get(minind).getUserTweet()[(index[minind] + 10)%10].getTimestamp())
                      {
                          minind = j;
                      }
                  }
              }
              
              newsFeed.add(newlist.get(minind).getUserTweet()[index[minind]].getTweetId());
              index[minind]--;
              
                  
              lenth[minind]--;
              if(index[minind] == -1  && lenth[minind] > 0)
                  index[minind] = 9;
          }
         
          return newsFeed;
      }
      
      /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
      public void follow(int followerId, int followeeId) {
          
          if(followeeId == followerId)
              return;
              
          User follower = alluser.get(followerId);
          User followee = alluser.get(followeeId);
          
          if(follower == null)
          {
              follower = new User(followerId);
              alluser.put(followerId, follower);
          }
          
          if(followee == null)
          {
              followee = new User(followeeId);
              alluser.put(followeeId, followee);
          }
          
          follower.setFollow(followee);
         
      }
      
      /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
      public void unfollow(int followerId, int followeeId) {
          
          User follower = alluser.get(followerId);
          User followee = alluser.get(followeeId);
          
          if(follower == null)
          {
              return;
          }
          
          if(followee == null)
          {
              return;
          }
          
          follower.unFollow(followee);
      }
  }

  /**
   * Your Twitter object will be instantiated and called as such:
   * Twitter obj = new Twitter();
   * obj.postTweet(userId,tweetId);
   * List<Integer> param_2 = obj.getNewsFeed(userId);
   * obj.follow(followerId,followeeId);
   * obj.unfollow(followerId,followeeId);
   */
