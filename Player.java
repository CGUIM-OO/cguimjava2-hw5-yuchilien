import java.util.ArrayList;
/**
 * Description: 
 * 	這是Player類別(繼承了Person類別)
 * field：姓名、玩家持有籌碼、玩家此局下注籌碼、玩家此局拿到的牌
 * method：回傳玩家名字、下注、設定這位玩家此牌局所得到的卡(存到oneRoundCard ArrayList)、
 * 	是否要牌(判斷自己目前點數總和，16點以下要牌，17點以上不要牌)、
 * 	此牌局自己所得的牌點數總和(加總oneRoundCard裡面的點數，JQK都算10點)、
 * 	回傳玩家現有籌碼、玩家籌碼變動、玩家Say Hello
 */
public class Player extends Person{

	private String name;// 玩家姓名
	private int chips;// 玩家持有的籌碼
	private int bet;// 玩家此局下注的籌碼
	//繼承private ArrayList<Card> oneRoundCard;// 玩家此牌局拿到的牌

	// Player constructor
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}

	//回傳玩家名字
	public String getName() {
		return name;
	}

	// 下注
	public int makeBet() {
		// 檢查籌碼是否為零
		if (chips != 0) {
			bet = bet;
		}
		// 沒籌碼了就不能再繼續下注
		else {
			bet = 0;
		}
		
		return bet;
	}
	
	// 設定這位玩家此牌局所得到的卡 
//	繼承public void setOneRoundCard(ArrayList<Card> cards) {
//		oneRoundCard=cards;
//	}
	
	// 是否要牌
	
	@Override
	public  boolean hit_me(Table table) {
		boolean hit;// 要牌回傳true，不再要牌則回傳false
		
		int myCardSum = getTotalValue();// 拿自己目前的點數總和來判斷
		
		// 16點以下要牌，17點以上不要牌
		if(myCardSum <= 16)
		{
			hit = true;
		}
		else {
			hit = false;
		}
		
		return hit;
	}
	// 此牌局自己所得的牌點數總和
//	繼承public int getTotalValue() {
//		int myCardSum = 0;
//		
//		for(Card c : oneRoundCard) 
//		{
//			if(c.getRank()<10) 
//			{
//				myCardSum += c.getRank();
//			}
//			//J,Q,K都算10
//			else {
//				myCardSum += 10;
//			}
//		}
//		return myCardSum;
//	}
	
	// 回傳玩家現有籌碼
	public int getCurrentChips() {
		return chips;
	}
	
	// 玩家籌碼變動
	public void increaseChips (int diff) {	
		bet = diff;
	}
	
	// 玩家Say Hello
	public void sayHello() {
		
		System.out.println("Hello, I am " + name + ".");
	    System.out.println("I have " + chips + " chips.");
	}
}
