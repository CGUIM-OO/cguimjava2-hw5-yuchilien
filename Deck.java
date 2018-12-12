import java.util.ArrayList;
import java.util.Random;

/**
 * Description: TODO: 
 * 	用迴圈產生所有的牌再放進ArrayList
 * 	迴圈第一層:共有幾副牌deck 迴圈第二層:分配花色suit 迴圈第三層:分配點數rank
 * 	洗牌：先判斷牌是否有用過，有的話就先加回去，取隨機的一張牌與某位置的牌交換
 * 	發牌：若是公開的牌會特別記錄起來，每張發出去的牌都會記錄，牌發光了會執行洗牌
 * 
 */
public class Deck {
	private ArrayList<Card> cards;// 現在牌面上的牌
	private ArrayList<Card> usedCards;// 存發過的牌
	private ArrayList<Card> openCard;//存放此副牌中所有打開的牌，洗牌時要重置
	public int nUsed;// 記錄發過幾張牌


	public Deck(int nDeck) {
		//初始化這些ArrayList
		cards = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		// 總共有幾副牌就產生
		for (int i = 0; i < nDeck; i++) {
			// 全部花色 
			for (Card.Suit s : Card.Suit.values()) {
				
				// 全部點數(1~13)
				for (int r = 1; r < 14; r++) {
					Card card = new Card(s, r);
					cards.add(card);
				}
			}

		}
		shuffle();
	}

	// 作業三 ：洗牌
	public void shuffle() {
		// 如果牌有用過
		if(usedCards.size() != 0)
		{
			// 把用過的牌加回去
			for(Card c : usedCards)
			{
				cards.add(c);
			}
			// 把用過的牌清空
			usedCards.clear();
			nUsed = 0;
		}
		
		Random rnd = new Random();
		// i是現在要處理的牌
		for (int i = 0; i < cards.size(); i++) {
			// j是隨機在所有cards中的一張牌
			int j = rnd.nextInt(cards.size());
			// 把第i張先記錄起來
			Card tmp = cards.get(i);
			// 第j張拿到第i張的位置
			cards.set(i, cards.get(j));
			// 第i張拿到第j張的位置
			cards.set(j, tmp);
		}
	}

	// 作業四，發牌修改(加入isOpened參數，決定發出去的牌是開著還是蓋起來的)
	public Card getOneCard (boolean isOpened) {
		// 拿出在第一個位置的牌
		Card c = cards.get(0);
		//若是開著的牌，加入openCard
		if(isOpened) {
			openCard.add(c);
		}
		
		// 把這張牌記錄起來
		
		usedCards.add(c);
		// 記錄多發了一張牌
		nUsed++;
		// 把這張牌刪掉
		cards.remove(c);
		// 如果牌發完了
		if (cards.size() == 0) {
			// 重新執行洗牌method
			shuffle();
		}
		// 回傳這張牌
		return c;
	}

	
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		
		// 印出牌面上所有的牌
		for (Card i : cards)// for each
		{
			i.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}
