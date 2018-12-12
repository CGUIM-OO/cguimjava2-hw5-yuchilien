import java.util.ArrayList;

public class Table {

	public final int MAXPLAYER = 4; // 最多一張牌桌能坐幾個人
	public Deck allCard; // 存放所有的牌
	public Player[] allPlayer; // 存放所有的玩家
	public Dealer aDealer; // 存放一個莊家
	public int[] pos_betArray; // 存放每個玩家在一局下的注

	// Constructor
	public Table(int nDeck) {

		Deck oneDeck = new Deck(nDeck); // Deck class實體化
		allCard = oneDeck; // 並存入上述新增的Deck變數
		allPlayer = new Player[MAXPLAYER]; // 初始化Player[]

	}

	// 將Player放到牌桌(某個位置放某個人)
	public void set_player(int pos, Player p) {

		allPlayer[pos] = p;

	}

	// 回傳所有在牌桌上的player
	public Player[] get_player() {

		return allPlayer;

	}

	// 將Dealer放到牌桌上
	public void set_dealer(Dealer d) {

		aDealer = d;
	}

	// 回傳dealer打開的那張牌，也就是第二張牌
	public Card get_face_up_card_of_dealer() {

		return allCard.getOneCard(true);

	}

	private void ask_each_player_about_bets() {

		// 每個玩家打招呼
		for (Player i : allPlayer) {
			i.sayHello();
		}

		// 每個玩家下注，存在pos_betArray
		for (int i = 0; i <= MAXPLAYER; i++) {
			pos_betArray[i] = allPlayer[i].makeBet();
		}
	}

	//發牌給玩家跟莊家，先發兩張打開的牌給玩家
	private void distribute_cards_to_dealer_and_players() {
		
		aDealer.setOneRoundCard(allCard.getOneCard(true));
		
	}

	//問每個玩家要不要牌
	private void ask_each_player_about_hits(Player[] allP) {
		int i;
		//依序詢問每一位家
		for (Player i : allPlayer) {
			boolean hit = false;
			do {
				hit = allP[i].hit_me(null); // this
				if (hit) {
					player1Card.add(deck.getOneCard(true));
					allP[i].setOneRoundCard(player1Card);
					System.out.print("Hit! ");
					System.out.println(allP[0].getName() + "'s Cards now:");
					for (Card c : player1Card) {
						c.printCard();
					}
				} else {
					System.out.println(allP[i].getName() + ", Pass hit!");
					System.out.println(allP[i].getName() + ", Final Card:");
					for (Card c : player1Card) {
						c.printCard();
					}
				}
			} while (hit);
		}

	}
	
	// 詢問莊家是否要牌
	private void ask_dealer_about_hits() {
		boolean hit;
		//一定會先問一次要不要
	    do
	    {
	    ArrayList<Card> cards = aDealer.getOneRoundCard();
	      hit = aDealer.hit_me(null);
	      if (hit)
	      {
	        cards.add(allCard.getOneCard(true));
	        aDealer.setOneRoundCard(cards);
	      }
	      if (aDealer.getTotalValue() > 21) {
	        hit = false;
	      }
	      //如果還有要牌就要再繼續問
	    } while (hit);
	    System.out.println("Dealer's hit is over!");
	}
	
	private void calculate_chips() {
		//印出莊家的點數和牌
		int aDealerCardValue = aDealer.getTotalValue();
		System.out.print("Dealer's card value is " + aDealerCardValue + " ,Cards:");
		aDealer.printAllCard();
		
	}
	


	public void play() {
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits(allPlayer);
		ask_dealer_about_hits();
		calculate_chips();

	}

	public int[] get_palyers_bet() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
