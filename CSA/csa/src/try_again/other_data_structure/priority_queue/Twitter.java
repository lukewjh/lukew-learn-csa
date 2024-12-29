package try_again.other_data_structure.priority_queue;

import java.util.*;

/**
 * @author lukew
 * @create 2024-10-18 9:33
 * 355.设计推特
 */
public class Twitter {

    //全局时间戳
    int globalTime = 0;
    //记录用户id到用户的映射
    HashMap<Integer,User> idToUser = new HashMap<>();

    class Tweet{
        //类似于单链表的推特类
        private int id;
        private int timestamp;

        private Tweet next;

        public Tweet(int id){
            this.id = id;
            this.timestamp = globalTime++;
        }

        public int getId(){
            return id;
        }

        public int getTimestamp(){
            return timestamp;
        }

        public Tweet getNext(){
            return next;
        }

        public void setNext(Tweet next){
            this.next = next;
        }

    }

    class User{
        private int id;

        private Tweet tweetHead;

        //记录该用户的关注者
        private HashSet<User> followedUserSet;

        public User(int id){
            this.id = id;
            this.tweetHead = null;
            this.followedUserSet = new HashSet<>();
        }

        public int getId(){
            return id;
        }

        public Tweet getTweetHead(){
            return tweetHead;
        }

        public HashSet<User> getFollowedUserSet(){
            return followedUserSet;
        }

        public boolean equals(User other){
            return this.id == other.id;
        }

        //关注他人
        public void follow(User other){
            followedUserSet.add(other);
        }

        //取关
        public void unfollow(User other){
            followedUserSet.remove(other);
        }

        //发布tweet
        public void post(Tweet tweet){
            tweet.setNext(tweetHead);
            tweetHead = tweet;
        }

    }

    public void postTweet(int userId, int tweetId){
        //如果这个用户还不存在 新建用户
        if (!idToUser.containsKey(userId)){
            idToUser.put(userId, new User(userId));
        }
        User user = idToUser.get(userId);
        user.post(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId){
        List<Integer> res = new LinkedList<>();
        if (!idToUser.containsKey(userId)){
            return res;
        }

        User user = idToUser.get(userId);
        Set<User> followedUserSet = user.getFollowedUserSet();

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> {
            return b.timestamp - a.timestamp;
        });

        if (user.getTweetHead() != null){
            pq.offer(user.getTweetHead());
        }

        for(User other : followedUserSet){

            if (other.getTweetHead() != null){
                pq.offer(other.tweetHead);
            }
        }

        //合并多条有序链表
        int count = 0;

        while(!pq.isEmpty() && count < 10){

            Tweet tweet = pq.poll();
            res.add(tweet.getId());

            if (tweet.getNext() != null){
                pq.offer(tweet.getNext());
            }
            count++;

        }

        return res;

    }

    public void follow(int followerId, int followeeId){

        if (!idToUser.containsKey(followerId)){
            idToUser.put(followerId,new User(followerId));
        }

        if (!idToUser.containsKey(followeeId)){
            idToUser.put(followeeId,new User(followeeId));
        }

        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);

        follower.follow(followee);

    }

    public void unfollow(int followerId, int followeeId){
        if (!idToUser.containsKey(followerId) || !idToUser.containsKey(followeeId)){
            return;
        }

        User follower = idToUser.get(followerId);
        User followee = idToUser.get(followeeId);

        follower.unfollow(followee);

    }


}


