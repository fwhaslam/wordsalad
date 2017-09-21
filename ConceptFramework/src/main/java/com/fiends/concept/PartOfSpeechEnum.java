package com.fiends.concept;

/**
 * This enumeration is basd on the University of Pennsylvania Treebank Tag Set for English
 *   see http://www.comp.leeds.ac.uk/amalgam/tagsets/upenn.html
 *   see https://en.wikipedia.org/wiki/Treebank
 *
 * Note that this is also use by StanfordNLP
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public enum PartOfSpeechEnum {

	// we don't know the part of speech
	Unknown("unknown"),

	// dollar ::
	// $ -$ --$ A$ C$ HK$ M$ NZ$ S$ U.S.$ US$
	Dollar("$"),

	// opening quotation mark ::
	// ` ``
	OpenQuote("``"),

	// closing quotation mark ::
	// ' ''
	CloseQuote("''"),

	// 	opening parenthesis ::
	// ( [ {
	OpenParen("("),

	// closing parenthesis :::
	// ) ] }
	CloseParen(")"),

	// comma ::
	// ,
	Comma(","),

	// dash ::
	// --
	Dash("--"),

	// sentence terminator ::
	// . ! ?
	CloseSentence("."),

	//colon or ellipsis ::
	// : ; ...
	ColonEllipsis(":"),

	// conjunction, coordinating ::
	// & 'n and both but either et for less minus neither nor or plus so therefore times v. versus vs. whether yet
	CoordinatingConjunction("CC"),

	// numeral, cardinal ::
	// mid-1890 nine-thirty forty-two one-tenth ten million 0.5 one forty-seven 1987 twenty '79 zero two 78-degrees eighty-four IX '60s .025 fifteen 271,124 dozen quintillion DM2,000 ...
	CardinalNumeral("CD"),

	// determiner ::
	// all an another any both del each either every half la many much nary neither no some such that the them these this those
	Determiner("DT"),

	// 	existential there ::
	// there
	ThereExists("EX"),

	// foreign word ::
	// gemeinschaft hund ich jeux habeas Haementeria Herr K'ang-si vous lutihaw alai je jour objets salutaris fille quibusdam pas trop Monte terram fiche oui corporis ...
	ForeignWord("FW"),

	// preposition or conjunction, subordinating ::
	// astride among uppon whether out inside pro despite on by throughout below within for towards near behind atop around if like until below next into if beside ...
	InNearAround("IN"),

	// adjective or numeral, ordinal ::
	// third ill-mannered pre-war regrettable oiled calamitous first separable ectoplasmic battery-powered participatory fourth still-to-be-named multilingual multi-disciplinary ...
	AdjectiveOrdinal("JJ"),

	// adjective, comparative ::
	// bleaker braver breezier briefer brighter brisker broader bumper busier calmer cheaper choosier cleaner clearer closer colder commoner costlier cozier creamier crunchier cuter ...
	AdjectiveCompare("JJR"),

	// adjective, superlative ::
	// calmest cheapest choicest classiest cleanest clearest closest commonest corniest costliest crassest creepiest crudest cutest darkest deadliest dearest deepest densest dinkiest ...
	AdjectiveSuperlative("JJS"),

	// list item marker ::
	// A A. B B. C C. D E F First G H I J K One SP-44001 SP-44002 SP-44005 SP-44007 Second Third Three Two \* a b c d first five four one six three two
	ListItem("LS"),

	// modal auxiliary ::
	// can cannot could couldn't dare may might must need ought shall should shouldn't will would
	ModalAuxiliary("MD"),

	// noun, common, singular or mass ::
	// common-carrier cabbage knuckle-duster Casino afghan shed thermostat investment slide humour falloff slick wind hyena override subhumanity machinist ...
	NounCommon("NN"),

	// noun, common, plural ::
	// undergraduates scotches bric-a-brac products bodyguards facets coasts divestitures storehouses designs clubs fragrances averages subjectivists apprehensions muses factory-jobs ...
	NounCommonPlural("NNS"),

	// noun, proper, singular ::
	// Motown Venneboerger Czestochwa Ranzer Conchita Trumplane Christos Oceanside Escobar Kreisler Sawyer Cougar Yvette Ervin ODI Darryl CTCA Shannon A.K.C. Meltex Liverpool ...
	NounProper("NNP"),

	// noun, proper, plural ::
	// Americans Americas Amharas Amityvilles Amusements Anarcho-Syndicalists Andalusians Andes Andruses Angels Animals Anthony Antilles Antiques Apache Apaches Apocrypha ...
	NounProperPlural("NNPS"),

	// genitive marker ::
	// ' 's
	Possesive("POS"),

	// pronoun, personal ::
	// hers herself him himself hisself it itself me myself one oneself ours ourselves ownself self she thee theirs them themselves they thou thy us
	PronounPersonal("PRP"),

	// pronoun, possessive ::
	// her his mine my our ours their thy your
	PronounPossesive("PRP$"),

	// adverb ::
	// occasionally unabatingly maddeningly adventurously professedly stirringly prominently technologically magisterially predominately swiftly fiscally pitilessly ...
	AdverbCommon("RB"),

	// adverb, superlative ::
	// best biggest bluntest earliest farthest first furthest hardest heartiest highest largest least less most nearest second tightest worst
	AdverbSuperlative("RBS"),

	// particle ::
	// aboard about across along apart around aside at away back before behind by crop down ever fast for forth from go high i.e. in into just later low more off on open out over per pie raising start teeth that through under unto up up-pp upon whole with you
	Particle("RP"),

	// symbol ::
	// % & ' '' ''. ) ). * + ,. < = > @ A[fj] U.S U.S.S.R \* \*\* \*\*\*
	Symbol("SYM"),

	// "to" as preposition or infinitive marker ::
	// to
	To("TO"),

	// interjection ::
	// Goodbye Goody Gosh Wow Jeepers Jee-sus Hubba Hey Kee-reist Oops amen huh howdy uh dammit whammo shucks heck anyways whodunnit honey golly man baby diddle hush sonuvabitch ...
	Interjection("UH"),

	// verb, base form ::
	// ask assemble assess assign assume atone attention avoid bake balkanize bank begin behold believe bend benefit bevel beware bless boil bomb boost brace break bring broil brush build ...
	VerbBase("VB"),

	// verb, past tense ::
	// dipped pleaded swiped regummed soaked tidied convened halted registered cushioned exacted snubbed strode aimed adopted belied figgered speculated wore appreciated contemplated ...
	VerbPast("VBD"),

	// verb, present participle or gerund ::
	// telegraphing stirring focusing angering judging stalling lactating hankerin' alleging veering capping approaching traveling besieging encrypting interrupting erasing wincing ...
	VerbPresentParticiple("VBG"),

	// verb, past participle ::
	// multihulled dilapidated aerosolized chaired languished panelized used experimented flourished imitated reunifed factored condensed sheared unsettled primed dubbed desired ...
	VerbPastParticiple("VBN"),

	// verb, present tense, not 3rd person singular ::
	// predominate wrap resort sue twist spill cure lengthen brush terminate appear tend stray glisten obtain comprise detest tease attract emphasize mold postpone sever return wag ...
	VerbPresentTenseNot3rd("VBP"),

	// verb, present tense, 3rd person singular ::
	// bases reconstructs marks mixes displeases seals carps weaves snatches slumps stretches authorizes smolders pictures emerges stockpiles seduces fizzes uses bolsters slaps speaks pleads ...
	VerbPresentTenseYes3rd("VBZ"),

	// WH-determiner ::
	// that what whatever which whichever
	WhichDeterminer("WDT"),

	// WH-pronoun ::
	// that what whatever whatsoever which who whom whosoever
	WhyPronoun("WP"),

	// WH-pronoun, possessive ::
	// whose
	WhyPronounPosessive("WP$"),

	// Wh-adverb ::
	// how however whence whenever where whereby whereever wherein whereof why
	WhyAdverb("WRB");

//======================================================================================================================

	/**
	 *
	 */
	String key;

	/**
	 *
	 * @param key
	 */
	PartOfSpeechEnum(String key){this.key=key;}

	/**
	 *
	 * @return
	 */
	public String getKey(){return key;}

	static public PartOfSpeechEnum fromKey(String key){
		if (key==null) return null;
		// 'unknown' cannot be parsed, it must be a system choice.
		if (!Unknown.key.equals(key))
			for (PartOfSpeechEnum value : values() )
				if (key.equals(value.getKey())) return value;
		throw new RuntimeException("Invalid PartOfSpeech key =["+key+"]");
	}

}
