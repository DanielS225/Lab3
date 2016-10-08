package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerEnums.eCardNo;

import pokerExceptions.exHand;;

public class Hand_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void TestRoyalFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		
	}
	
	
	@Test
	public void TestStraightFlush() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers() == null);	
		
		try {
			h.EvaulateHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(h.getHs().getHandStrength());
	}
	
	
	@Test
	public void TestFourOfAKind() {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = Hand.EvaluateHand(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers().size() == 1);
		
		Card c1 = h.getHs().getKickers().get(eCardNo.FirstCard.getCardNo());
		
		assertTrue(c1.geteRank().getiRankNbr() == eRank.NINE.getiRankNbr());
	}
	
	@Test
	public void FiveOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		
	}
	
	@Test
	// Five of a Kind Test with a Joker
	public void JFiveOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		
	}
	
	@Test
	// Test Natural Royal Flush (no Jokers)
	public void NaturalRoyalFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvaulateHand();
		
		//assertTrue(h.getHs().getHandStrength() == eHandStrength.NaturalRoyalFlush.getHandStrength());
		assertTrue(h.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		
	}

	@Test
	// Test Royal Flush with Jokers
	public void RoyalFlush() throws exHand{
		// A deck with 3 jokers and a King and Ace of clubs should evaluate to a Royal Flush
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvaulateHand();
		assertTrue(h.getHs().getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		
	}
	
	@Test
	// Straight Flush with Joker
	public void JStraightFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers() == null);	
	}
	
	@Test
	public void Flush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers() == null);
	}
	
	@Test
	// Test Flush with a Joker
	public void JFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.ACE.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers() == null);
	}
	
	@Test
	public void Straight() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.JACK,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers() == null);
	}
	
	@Test
	//Test a Straight with a Joker
	public void JStraight() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.JACK,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.KING.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers() == null);
	}
	
	@Test
	public void ThreeOfAKind_1() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers().size() == 2);
	}		
	@Test
	public void ThreeOfAKind_2() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.KING,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers().size() == 2);
		
		Card c1 = h.getHs().getKickers().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getHs().getKickers().get(eCardNo.SecondCard.getCardNo());
		
		//	Check to see if the first kicker is a KING
		assertTrue(c1.geteRank().getiRankNbr() == eRank.KING.getiRankNbr());
		
		//	Check to see if the second kicker is a NINE
		assertTrue(c2.geteRank().getiRankNbr() == eRank.NINE.getiRankNbr());
	}		
	@Test
	public void ThreeOfAKind_3() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.THREE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers().size() == 2);
		
		Card c1 = h.getHs().getKickers().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getHs().getKickers().get(eCardNo.SecondCard.getCardNo());
		
		//	Check to see if the first kicker is a THREE
		assertTrue(c1.geteRank().getiRankNbr() == eRank.THREE.getiRankNbr());
		
		//	Check to see if the second kicker is a TWO
		assertTrue(c2.geteRank().getiRankNbr() == eRank.TWO.getiRankNbr());		
	}
	
	@Test
	// Test a three of a kind with a Joker
	public void JThreeOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == 0);
		assertTrue(h.getHs().getKickers().size() == 2);
	}	
	@Test
	public void FullHouse_1() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.TWO.getiRankNbr());
		assertTrue(h.getHs().getKickers() == null);	
	}		
	@Test
	public void FullHouse_2() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TWO.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getKickers() == null);	
	}	
	
	@Test
	// Test Full House with a Joker - will always be the high card
	public void JFullHouse() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.TWO.getiRankNbr());
		assertTrue(h.getHs().getKickers() == null);	
	}	
	
	//Note: A hand with a Joker will NEVER evaluate to a two pair (logic)
	@Test
	public void TwoPair() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddToCardsInHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddToCardsInHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvaulateHand();
		
		assertTrue(h.getHs().getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHs().getHiHand() == eRank.TEN.getiRankNbr());
		assertTrue(h.getHs().getLoHand() == eRank.TWO.getiRankNbr());
		assertTrue(h.getHs().getKickers().size() == 1);
		
		Card c1 = h.getHs().getKickers().get(eCardNo.FirstCard.getCardNo());
		
//		Check to see if the first kicker is a THREE
			assertTrue(c1.geteRank().getiRankNbr() == eRank.ACE.getiRankNbr());
	}
	
	


}
