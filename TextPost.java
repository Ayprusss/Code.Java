public class TextPost extends Post {

    private String message;

    public TextPost(String userName, String message) {
      super(userName);
      this.message = message;
      toString();
      // Your code here.
    }

    public String getMessage() {
	     return message;
    }

    public String toString() {
    	String str = new String();
    	str = super.toString() + ", " + message;
    	return  str;
    }

  	public boolean isPopular() {
      Boolean marker = false;
      if (super.getLikes() >= 50) {
        marker = true;
      }
      return marker;
  		// Your code here.
  	}

}
