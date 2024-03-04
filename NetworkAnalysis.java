import java.util.ArrayList;

public class NetworkAnalysis {
	
	ArrayList<String> rows = new ArrayList<>();


	NetworkAnalysis(String xml){
		
		String[] rowsArray = xml.trim().replace(" ", "").replaceAll(">", ">\n").replaceAll("<", "\n<").split("\n");
		/* delete empty rows */
		for (String s : rowsArray){
			if (!s.isEmpty()){
				rows.add(s);
			}
		}
	}


	/*
		Desc: returns user ID with most followers
	*/
	public int getMostInfluencerUser(){

		int mostInfluencerFollowers=0, mostInfluencerID=0;
		int currentUserFollowers=0, currentUserID=0;

		for (int i=0; i< rows.size(); i++){
			/**
			 * user tag, followed by id tag, so the following row contains ID number
			 */
			if (rows.get(i).equals("<user>") && rows.get(i+1).equals("<id>")){
				currentUserID = getUserID(i+2);
				currentUserFollowers = getCurrentUserFollowers(i);

				if (currentUserFollowers > mostInfluencerFollowers){
					
					mostInfluencerID = currentUserID;
					mostInfluencerFollowers = currentUserFollowers;
				}
			}
		}

		return mostInfluencerID;
	}


	/*
	 * Desc: retruns number of followers for a specific user 
	 * */
	public int getCurrentUserFollowers(int startingIndex) {

		int followers =0;

		/** count how many <follower> tags are there, till we get to </followers> closing tag */
		for (int i=startingIndex; i< rows.size(); i++) {
			
			if (rows.get(i).equals("<follower>")){
				followers++;
			}else if (rows.get(i).equals("</followers>")){
				break;
			}
		}

		return followers;
	}


	/**
	 * Desc: returns the ID of a user
	 * 	parameter: index of the row that holds the ID number
	 */
	public int getUserID(int Index){
		int id=0;
		id = Integer.parseInt(rows.get(Index));
		return id;
	}
}
