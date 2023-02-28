
import java.util.Calendar;
import java.util.Date;

public class Post implements Comparable<Post>, Likeable {

    protected int likes;
    private Date timeStamp;
    private String userName;
    /*public Likeable Like;
    public Likeable getLikes */

    public void like() {
      this.likes ++;
      }

    public int getLikes() {
      return likes; 
      }
    
    public Post(String userName) {
      this.userName = userName;
      this.timeStamp = getTimeStamp();
      this.likes = getLikes();
    
    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
      Date timeStamp = Calendar.getInstance().getTime();
	     return timeStamp;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.

    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return str;
    }

  	public int compareTo(Post other){
      int marker = 0;
      if (this.timeStamp.equals(other.timeStamp)) {
        marker = 0;
      }
      else if (!this.timeStamp.equals(other.timeStamp)) {
        int date = Integer.parseInt(String.valueOf(this.timeStamp));
        int date2= Integer.parseInt(String.valueOf(other.timeStamp));

        if ((date - date2) > 0) {
          marker ++;
        }
        else if ((date - date2) < 0) {
          marker --;
        }
      }
      return marker;
  		// Your code here.
  	}

  	public boolean isPopular(){
      Boolean marker = false;
  		if (this.likes >= 100) {
        marker = true;
      }
      return marker;
  	}

}
