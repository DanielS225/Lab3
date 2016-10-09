package pokerEnums;

public enum eHandStrength {
	//TODO handle jokers
	NaturalRoyalFlush(110, "isHandNaturalRoyalFlush") {
		public String toString() {
			return "Natural Royal Flush";
		}
	},
	RoyalFlush(105, "isHandRoyalFlush") {
		public String toString() {
			return "Royal Flush";
		}
	},
	/*NaturalStraightFlush(100, "isHandNaturalStraightFlush") {
		public String toString() {
			return "Natural Straight Flush";
		}
	},*/
	StraightFlush(95, "isHandStraightFlush") {
		public String toString() {
			return "Straight Flush";
		}
	},
	FiveOfAKind(90, "isHandFiveOfAKind") {
		public String toString() {
			return "Five of a Kind";
		}
	},
	/*NaturalFourOfAKind(85, "isHandNaturalFourOfAKind") {
		public String toString() {
			return "Natural Four of a Kind";
		}
	},*/
	FourOfAKind(80, "isHandFourOfAKind") {
		public String toString() {
			return "Four of a Kind";
		}
	},
	/*NaturalFullHouse(75, "isHandNaturalFullHouse") {
		public String toString() {
			return "NaturalFull House";
		}
	},*/
	FullHouse(70, "isHandFullHouse") {
		public String toString() {
			return "Full House";
		}
	},
	/*NaturalFlush(65, "isHandNaturalFlush") {
		public String toString() {
			return "Natural Flush";
		}
	},*/
	Flush(60, "isHandFlush") {
		public String toString() {
			return "Flush";
		}
	},
	/*NaturalStraight(55, "isHandNaturalStraight") {
		public String toString() {
			return "Natural Straight";
		}
	},*/
	Straight(50, "isHandStraight") {
		public String toString() {
			return "Straight";
		}
	},
	/*NaturalThreeOfAKind(45, "isHandNaturalThreeOfAKind") {
		public String toString() {
			return "Natural Three of a Kind";
		}
	},*/
	ThreeOfAKind(40, "isHandThreeOfAKind") {
		public String toString() {
			return "Three of a Kind";
		}
	},
	/*NaturalTwoPair(35, "isHandNaturalTwoPair") {
		public String toString() {
			return "Natural Two Pairs";
		}
	},*/
	TwoPair(30, "isHandTwoPair") {
		public String toString() {
			return "Two Pairs";
		}
	},
	/*NaturalPair(25, "isHandNaturalPair") {
		public String toString() {
			return "Natural One Pair";
		}
	},*/
	Pair(20, "isHandPair") {
		public String toString() {
			return "One Pair";
		}
	},
	/*NaturalHighCard(15, "isHandNaturalHighCard") {
		public String toString() {
			return "Natural High Card";
		}
	},*/
	HighCard(10, "isHandHighCard") {
		public String toString() {
			return "High Card";
		}
	};

	private eHandStrength(final int handstrength, final String EvalMethod) {
		this.iHandStrength = handstrength;
		this.strEvalMethod = EvalMethod;
	}

	private int iHandStrength;
	private String strEvalMethod;

	public int getHandStrength() {
		return iHandStrength;
	}

	public String getEvalMethod() {
		return this.strEvalMethod;
	}

}
