
 public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
			messages = new Post[MAX_SIZE];
		
    }

    public void add(Post message) {
      for (int a = 0; a < MAX_SIZE; a ++) {
		if (messages[a] == null) {
			messages[a] = message;
			size ++;
			break;
		}
	  }
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
		NewsFeed newPost = new NewsFeed();
		for (int a = 0; a < messages.length; a ++) {
			if ((messages[a] instanceof PhotoPost)) {
				PhotoPost postinst = (PhotoPost) messages[a];
				newPost.add(postinst);
			}
		}
  		return newPost;
  	}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed newList = new NewsFeed();

  		for (int a = 0; a < size(); a ++) {
		newList.add(this.messages[a]);
		}

		for (int b = 0; b < other.size(); b ++) {
		newList.add(other.messages[b]);
	}

	newList.sort();
	return newList;
	}
}