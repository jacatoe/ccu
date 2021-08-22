;;;
;;; Mythos
;;;
;;; An Expert system on the Gods of Ancient Greece. 
;;; Also contains cross references to the Roman equivelents, (where they
;;; exist). 
;;; Originally Created by Paul S. Cerkez
;;; 20 Apr 1994.
;;;
;;; Modified/updated for CLIPS 6.4 on 9 Mar 2020 
;;;
;;; Modified by Joshua Catoe for CSCI 480 on 4 Apr 2020
;;; Added sections "birth", "death" and "events"
;;; All mythological information obtained from https://www.greekmythology.com/
;;; *************** 

;;; ******************** 
;;; facts, just the facts
;;; ******************** 

(deftemplate person ""
	(field child (type SYMBOL)) 
	(field father (type SYMBOL)) 
	(field mother (type SYMBOL))) 
(deffacts people ""
	(person ( child aias)(father telemon)(mother unknown)) 
	(person ( child aphrodite)(father zeus)(mother dione))  
	(person ( child apollo)(father zeus)(mother leto))  
	(person ( child ares)(father zeus)(mother hera))  
	(person ( child artemis)(father zeus)(mother leto))  
	(person ( child asklepios)(father apollo)(mother koronis))  
	(person ( child athena)(father zeus)(mother no-one))  
	(person ( child boreas)(father astraeus)(mother eos))  
	(person ( child charities)(father zeus)(mother eurynome))  
	(person ( child cronus)(father ouranos)(mother gaea))  
	(person ( child demeter)(father cronus)(mother rhea))  
	(person ( child dionysus)(father zeus)(mother semele))  
	(person ( child eos)(father hyperion)(mother theia))  
	(person ( child eros)(father unknown)(mother aphrodite))  
	(person ( child eumenidies)(father ouranos)(mother none)) 
	(person ( child gaea)(father chaos)(mother none)) 
	(person ( child hades)(father cronus)(mother rhea)) 
	(person ( child hera)(father cronus)(mother rhea)) 
	(person ( child heracles)(father zeus) (mother alcmene)) 
	(person ( child hermes)(father zeus)(mother maia)) 
	(person ( child leto)(father coeus)(mother phoebe)) 
	(person ( child moirai)(father zeus)(mother themis)) 
	(person ( child odysseus)(father laertes)(mother unknown)) 
	(person ( child ouranos)(father none)(mother gaea)) 
	(person ( child pan)(father hermes)(mother unknown)) 
	(person ( child persephone)(father zeus)(mother demeter)) 
	(person ( child polydueces)(father zeus)(mother leda)) 
	(person ( child poseidon)(father cronus)(mother rhea)) 
	(person ( child zeus)(father cronus)(mother rhea)) 
	(person ( child zephyrus)(father astraeus)(mother eos)) 
	(person ( child eurus)(father astraeus)(mother eos)) 
	(person ( child notus)(father astraeus)(mother eos)) 
	(person ( child phosphorus)(father astraeus)(mother eos)) 
	(person ( child hesperus)(father astraeus)(mother eos)) 
	(person ( child memnon)(father tithonus)(mother eos)) 
	(person ( child ethiopia)(father tithonus)(mother eos))) 

(deftemplate god ""
	(field greek (type SYMBOL)) ;the main name for the god/goddess 
	(field fame (type STRING))) ;associated with/claim to fame 
(deffacts gods ""
	(god ( greek zeus)
	 	(fame 
	"Zeus was known as the father of the gods and men, and Lord of Olympus. He defeated Cronus (his father) and the Titans and thus became master of the world.")) 

	(god ( greek hera) 
		(fame 
	"Queen of heaven, and wife of Zeus. An exacting and jealous wife who took severe vengence upon the numerous mortal maidens seduced by her husband. She also was none too fond of the offspring. In the Trojan War, she was on the side of the Greeks")) 

	(god ( greek gaea) 
		(fame "The first being that sprang from Chaos. She is the personification of the earth. She gave birth to Ouranus, and together, they produced the Titans.")) 

	(god ( greek charites) 
		(fame " The attendants of Aphrodite. They represent the perfection of grace in body and mind")) 

	(god ( greek hecate) 
		(fame "Goddess of socery and witchcraft, often represented with three heads. She personified the darkness and the terror of night. She was the only Titan Zeus al towed to retain their powers. Her domain extended over heaven, earth and hell. She was associated with howling of dogs, because only dogs could see her and their barking annouced her approach.")) 

	(god ( greek cronus) 
		(fame "Encouraged by his mother, he overthrew and castrated his father. His rule was the Golden Age, when there was no pain or suffering in the world. To prevent his being overthrown, he swallowed all of his offspring. His wife hid the youngest, Zeus, from him. When Zeus was older, he rebelled and started the war of the Olympians against the Titans.")) 

	(god (greek hades) 
		(fame "Brother of Zeus, ruler of the Kingdom of the Underworld. The name Hades came to later represent the region of the Kingdom of the Underworld. This region is not Hell, but the place all dead, good and evel, go to spend eternity"))
 
	(god (greek hebe) 
		(fame "First wife of Heracles, cupbearer to the gods."))) 

(deftemplate celestial-body-r "" (field roman (type SYMBOL)) (field planet (type STRING))) 
(deftemplate celestial-body-g "" (field greek (type SYMBOL)) (field planet (type STRING))) 

(deffacts planets ""
	(celestial-body-r (roman mercury) 
		(planet "The planet mercury is the closest planet to the sun."))
	(celestial-body-g (greek paltas) 
		(planet "The second of the 10 minor planets (asteriods)")) 
	(celestial-body-g (greek hebe) 
		(planet "The sixth of the 10 minor planets (asteriods)")) 
	(celestial-body-g (greek callisto) 
		(planet "The fourth moon of Jupiter")) 
	(celestial-body-r (roman venus) 
		(planet "The second planet in our solar system")) 
	(celestial-body-r (roman terra) 
		(planet "Terra is other wise known as earth, the 3rd planet in the system"))
	(celestial-body-r (roman neptune) 
		(planet "The water planet. The eigtht planet in the system"))
) 

(deftemplate constellation ""
	(field roman (type SYMBOL)) 
	(field stars (type STRING))
) 

(deffacts constellations ""
	(constellation (roman hercules) 
	(stars "A constellation in the northern hemisphere."))
) 

(deftemplate celestial-place ""
	(field roman (type SYMBOL)) 
	(field place (type STRING))
) 

(deffacts heavenly-locals "" 
	(celestial-place (roman hercules) 
	(place "A lunar crater in the northeast sector near the sea of serenity. Position 46N39E"))
) 

;;; id the input name, and convert to greek, 
;;  tag with entity type 
;; god 
;; goddess
;; group
;; immortal
;; titan
;; human 
;; thing
;; animal
;; place 

(defrule identity ""
	(identify ?in) 
	=>
	(bind ?in (lowcase ?in)) 
	(assert(in-name ?in))
) 

(defrule asklepios ""
	(in-name ?in) 
	(or (in-name asklepios) 
	    (in-name aesculapius)
	) 
	=>
	(assert (entity god asktepios)) 
	(assert (greek asklepios)) 
	(assert (roman aesculapias))
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase asklepios)) 
	(bind ?name-r (upcase aesculapius)) 
	(format t "%n The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf ) 
	(format t "%n He is known to the Greeks as %s" ?name-g) 
	(printout t crlf ) 
	(format t "%nand to the Romans as %s" ?name-r) 
	(assert (parents-of askelepios)) 
	(assert (children-of askelepios)) 
	(printout t crlf crlf crlf)
)

(defrule boreas ""
	(in-name ?in) 
	(or (in-name boreas) 
	    (in-name aguilo)
	)
 	=>
	(assert (entity thing boreas)) 
	(assert (greek boreas )) 
	(assert (roman aguilo )) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase thing)) 
	(bind ?name-g (upcase boreas)) 
	(bind ?name-r (upcase aguilo)) 
	(format t "The name you entered, %s, is the personification of the north wind" ?query) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s" ?name-r) 
	(assert (parents-of boreas)) 
	(assert (children-of boreas)) 
	(printout t crlf crlf crlf)
) 

(defrule aias ""
	(in-name ?in) 
	(or (in-name aias) 
	    (in-name ajax))
	=> 
	(assert (entity human aias)) 
	(assert (greek aias )) 
	(assert (roman ajax )) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase human)) 
	(bind ?name-g (upcase aias)) 
	(bind ?name-r (upcase ajax)) 
	(format t "The name you entered, %s, was a %s." ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s" ?name-r) 
	(assert (parents-of aias)) 
	(assert (children-of aias)) 
	(printout t crlf crlf crlf)
) 

(defrule eros ""
	(in-name ?in) 
	(or (In-name eros) 
	    (in-name cupid) 
	    (in-name amor)
	) 
	=> 
	(assert (Latin amor)) 
	(assert (entity god eros)) 
	(assert (greek eros )) 
	(assert (roman cupid )) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase eros)) 
	(bind ?name-r (upcase cupid))
	(bind ?name-l (upcase amor)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "to the Romans as %s, and in Latin as %s" ?name-r ?name-l) 
	(assert (parents-of eros)) 
	(assert (children-of eros)) 
	(printout t crlf crtf crlf)
)
 
(defrule apollo ""
	( in-name ?in) 	
	(or 
		(in-name apollo) 
		(in-name lykeious) 
		(in-name phoebus) 
		(in-name namois) 
		(in-name far-darter)
	) 
	=> 
	(assert (entity god apollo)) 
	(assert (greek lykeious)) 
	(assert (greek phoebus)) 
	(assert (greek namois)) 
	(assert (greek far-darter)) 
	(assert (greek apollo)) 
	(assert (roman apollo)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g1 (upcase apollo)) 
	(bind ?name-g2 (upcase phoebus)) 
	(bind ?name-g3 (upcase far-darter)) 
	(bind ?name-g4 (upcase namois)) 
	(bind ?name-g5 (upcase lykeious)) 
	(bind ?name-r (upcase apollo)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s, and %s, as well as %s, %s and %s" ?name-g1 ?name-g2 ?name-g3 
?name-g4 ?name-g5) 
	(printout t crlf) 
	(format t "The Romans also know him as %s" ?name-r) 
	(assert (parents-of apollo)) 
	(assert (children-of apollo)) 
	(printout t crlf crlf)) 


(defrule eos ""
	(in-name ?in) 
	(or (in-name eos) 
	    (in-name aurora)
	) 
	=>
	(assert (entity goddess eos)) 
	(assert (greek eos )) 
	(assert (roman aurora )) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g (upcase eos)) 
	(bind ?name-r (upcase aurora)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of eos)) 
	(assert (children-of eos)) 
	(printout t crlf crlf crlfl))

(defrule ouranus ""
	(in-name ?in)
	(or (in-name ouranus )
	    (in-name caulus )
	) 
	=> 
	(assert (entity pre-god ouranus )) 
	(assert (greek ouranus )) 
	(assert (roman caulus )) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase pre-titan)) 
	(bind ?name-g (upcase ouranus)) 
	(bind ?name-r (upcase caulus)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g)
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of ouranus)) 
	(assert (children-of ouranus)) 
	(printout t crlf crlf crlf)) 


(defrule demeter ""
	(in-name ?in) 
	(or (in-name demeter )
	    (in-name ceres )
	) 
	=>
	(assert (entity goddess demeter)) 
	(assert (greek demeter)) 
	(assert (roman ceres)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g (upcase demeter)) 
	(bind ?name-r (upcase ceres)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r )
	(assert (parents-of demeter)) 
	(assert (children-of demeter)) 
	(printout t crlf crlf crlf)) 


(defrule artemis ""
	(in-name ?in) 
	(or (in-name artemis) 
	    (in-name parthenos) 
	    (in-name kalliste) 
	    (in-name selene) 
	    (in-name diana)) 
	=>
	(assert (entity goddess artemis)) 
	(assert (greek artemis)) 
	(assert (greek parthenos)) 
	(assert (greek kalliste)) 
	(assert (greek selene)) 
	(assert (roman diana)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g1 (upcase artemis)) 
	(bind ?name-g2 (upcase kalliste)) 
	(bind ?name-g3 (upcase salene)) 
	(bind ?name-g4 (upcase parthenos)) 
	(bind ?name-r (upcase minerva)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She was known to the Greeks as %s, and %s, as well as %s, and %s" ?name-g1 ?name-g2 ?name-g3 
?name-g4 ) 
	(printout t crlf) 
	(format t "white to the Romans she was known as %s" ?name-r) 
	(assert (parents-of artemis)) 
	(assert (children-of artemis)) 
	(printout t crlf crlf)) 

(defrule pan ""
	(in-name ?in) 
	(or (in-name pan) 
	    (in-name faunus)) 
	=>
	(assert (entity god pan)) 
	(assert (greek pan)) 
	(assert (roman faunus)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase pan)) 
	(bind ?name-r (upcase faunus)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of pan)) 
	(assert (children-of faunus)) 
	(printout t crlf crlf crlf)) 

(defrule zephyrus ""
	(in-name ?in) 
	(or (in-name zephyrus) 
	    (in-name favonius)) 
	=>
	(assert (entity thing zephyrus )) 
	(assert (greek zephyrus)) 
	(assert (roman favonius)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase thing)) 
	(bind ?name-g (upcase hermes)) 
	(bind ?name-r (upcase mercury)) 
	(format t "The name you entered, %s, is the personification of the west wind." ?query) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	( format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of zephyrus)) 
	(assert (children-of zephyrus)) 
	(printout t crlf crH crlf)) 

(defrule chloris ""
	(in-narne ?in) 
	(or (in-name chloris) 
	    (in-name flora)) 
	=>
	(assert (entity thing chloris)) 
	(assert (greek chloris)) 
	(assert (roman flora)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase thing)) 
	(bind ?name-g (upcase chloris)) 
	(bind ?name-r (upcase flora)) 
	(format t "The name you entered, %s, is the personification of Spring." ?query) 
	(printout t crlf) 
	(format t "She is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of chloris)) 
	(assert (children-of chloris)) 
	(printout t crlf crlf crlf)) 

(defrule eunenides ""
	(in-name ?in) 
	(or (in-name eumenides) 
	    (in-name alecto) 
	    (in-name tisiphone) 
	    (in-name magaera) 
	    (in-name erinyes) 
	    (in-name furies) 
	    (in-name furiae)) 
	=> 
	(assert (entity group eumenides)) 
	(assert (entity goddess atecto)) 
	(assert (entity goddess tisiphone)) 
	(assert (entity goddess magaera)) 
	(assert (greek alecto)) 
	(assert (greek tisiphone)) 
	(assert (greek magaera)) 
	(assert (greek erinyes)) 
	(assert (roman furies)) 
	(assert (greek eumenides)) 
	(assert (roman furiae))
) 

(defrule charites ""
	(in-name ?in) 
	(or (in-name charites) 
	    (in-name euphrosyne )
	    (in-name aglaia) 
	    (in-name thalia) 
	    (in-name graces) 
	    (in-name gratiae)
	) 
	=>
	(assert (entity group charites)) 
	(assert (entity goddess euphrosyne )) 
	(assert (entity goddess aglaia)) 
	(assert (entity goddess thalia)) 
	(assert (greek euphrosyne )) 
	(assert (greek aglaia))
	(assert (greek thalia)) 
	(assert (roman graces)) 
	(assert (greek charites)) 
	(assert (roman gratiae))
) 

(defrule heracles ""
	( in-name ?in) 
	(or (in-name heracles) 
	    (in-name alcides) 
	    (in-name hercules)) 
	=>
	(assert (entity immortal heracles)) 
	(assert (greek alcides)) 
	(assert (greek heracles)) 
	(assert (roman hercules)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase immortal)) 
	(bind ?name-g (upcase heracles)) 
	(bind ?name-r (upcase hercules)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of heracles)) 
	(assert (children-of heracles)) 
	(printout t crlf crlf crlf)) 

(defrule hera ""
	(in-name ?in) 
	(or (in-name hera) 
	    (in-name juno)
	)
	=> 
	(assert (entity goddess hera)) 
	(assert (greek hera)) 
	(assert (roman juno)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g (upcase hera)) 
	(bind ?name-r (upcase juno)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r )
	(assert (parents-of hera)) 
	(assert (children-of hera)) 
	(printout t crlf crlf crlf)
) 

(defrule zeus "" 
	(in-name ?in) 
	(or (in-name zeus)
	    (in-name jove) 
	    (in-name jupiter )
	) 
	=>
	(assert (entity god zeus)) 
	(assert (greek zeus)) 
	(assert (roman jupiter)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase zeus)) 
	(bind ?name-r (upcase jupiter)) 
	(bind ?name-l (upcase jove)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s and in Latin it is %s %n" ?name-r ?name-l) 
	(assert (parents-of zeus)) 
	(assert (children-of zeus)) 
	(printout t crlf crlf crlf)
) 


(defrule leto ""
	(in-name ?in) 
	(or (in-name leto) 
	    (in-name latona)
	) 
	=>
	(assert (entity human leto )) 
	(assert (greek leto)) 
	(assert (roman latona)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase human)) 
	(bind ?name-g (upcase leto)) 
	(bind ?name-r (upcase latona)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She is known to the Greeks as %s " ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r )
	(assert (parents-of Leto)) 
	(assert (children-of Leto)) 
	(printout t crlf crlf crlf)
) 


(defrule dionysus ""
	(in-name ?in) 
	(or (in-name dionysus) 
	    (in-name bacchus)) 
	=>
	(assert (entity god dionysus)) 
	(assert (greek dionysus)) 
	(assert (roman bacchus)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase dionysus)) 
	(bind ?name-r (upcase bacchus)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of dionysus)) 
	(assert (children-of dionysus)) 
	(printout t crlf crlf crlf)) 


(defrule ares ""
	(in-name ?in)
	 (or (in-name ares) 
	     (in-name mars )) 
	=>
	(assert (entity god ares )) 
	(assert (greek ares)) 
	(assert (roman mars)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase ares)) 
	(bind ?name-r (upcase mars)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of ares)) 
	(assert (children-of ares)) 
	(printout t crlf crlf crlf)) 

 
(defrule hermes ""
	(in-name ?in) 
	(or (in-name hermes) 
	    (in-name mercury)) 
	=>
	(assert (entity god hermes)) 
	(assert (greek hermes)) 
	(assert (roman mercury)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase hermes)) 
	(bind ?name-r (upcase mercury)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s." ?name-r ) 
	(assert (parents-of hermes)) 
	(assert (children-of hermes)) 
	(printout t crlf crlf crlf))

 
(defrule athena ""
	(in-name ?in) 
	(or (in-name athena) 
	    (in-name pallas) 
	    (in-name pallas-athena) 
	    (in-name polias) 
	    (in-name bulaia) 
	    (in-name parthenos) 
	    (in-name minerva)) 
	=> 
	(assert (entity goddess athena)) 
	(assert (greek pallas)) 
	(assert (greek pallas-athena)) 
	(assert (greek polias)) 
	(assert (greek bulaia)) 
	(assert (greek parthenos)) 
	(assert (greek athena)) 
	(assert (roman minerva)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase human)) 
	(bind ?name-g1 (upcase athena)) 
	(bind ?name-g2 (upcase pallas)) 
	(bind ?name-g3 (upcase pallas-athena)) 
	(bind ?name-g4 (upcase polias)) 
	(bind ?name-g5 (upcase bulaia)) 
	(bind ?name-g6 (upcase parthenos)) 
	(bind ?name-r (upcase minerva)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She was known to the Greeks as %s, %s and %s, as well as %s, %s, and %s" ?name-g1 ?name-g2 ?name-g3 ?name-g4 ?name-g5 ?name-g6) 
	(printout t crlf) 
	(format t "while to the Romans she was known as %s" ?name-r) 
	(assert (parents-of athena)) 
	(assert (children-of athena)) 
	(printout t crlf crlf)) 


(defrule poseidon ""
	(in-name ?in) 
	(or (in-name poseidon) 
	    (in-name neptune)) 
	=>
	(assert (entity god poseidon)) 
	(assert (greek poseidon)) 
	(assert (roman neptune)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase poseidon)) 
	(bind ?name-r (upcase neptune)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans he was known as %s" ?name-r) 
	(assert (parents-of poseidon)) 
	(assert (children-of poseidon)) 
	(printout t crlf crlf)) 


(defrule moirai ""
	(in-name ?in) 
	(or (in-name moirai) 
	    (in-name clotho) 
	    (in-name lachssis) 
	    (in-name atropos) 
	    (in-name fates) 
   	    (in-name parcae)) 
	=>
	(assert (entity group moirai)) 
	(assert (enfity goddess clotho)) 
	(assert (entity goddess lachssis)) 
	(assert (entity goddess atropos)) 
	(assert (greek moirai)) 
	(assert (greek clotho)) 
	(assert (greek lachssis)) 
	(assert (greek atropos)) 
	(assert (roman fates)) 
	(assert (roman parcae))) 


(defrule eirene ""
	(in-name ?in) 
	(or (in-name eirene) 
	    (in-name pax)) 
	=>
	(assert (entity goddess eirene )) 
	(assert (greek eirene)) 
	(assert (roman pax)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g (upcase eirene)) 
	(bind ?name-r (upcase pax)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans she was known as %s" ?name-r) 
	(assert (parents-of eirene)) 
	(assert (children-of eirene)) 
	(printout t crlf crlf)) 


(defrule hades ""
	(in-name ?in) 
	(or ( in-name hades) 
	    (in-name pluto)) 
	=> 
	(assert (entity god hades)) 
	(assert (greek hades)) 
	(assert (roman pluto)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase hades)) 
	(bind ?name-r (upcase pluto)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t " while to the Romans he was known as %s" ?name-r) 
	(assert (parents-of hades)) 
	(assert (children-of hades)) (printout t crlf crlf)) 


(defrule polydeuces ""
	( in-name ?in) 
	(or (in-name polydeuces) 
	    (in-name pollux)) 
	=> 
	(assert (entity human polydeuces)) 
	(assert (greek polydeuces)) 
	(assert (roman pollux)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase human)) 
	(bind ?name-g (upcase polydeuces)) 
	(bind ?name-r (upcase pollux)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans he known as %s" ?name-r)
	(assert (parents-of polydeuces)) 
	(assert (children-of polydeuces)) 
	(printout t crlf crlf))


(defrule persephone ""
	(in-name ?in) 
	(or (in-name persephone) 
	    (in-name kore) 
  	    (in-name proserpina)) 
	=>
	(assert (entity goddess persephone )) 
	(assert (greek kore)) 
	(assert (greek persephone)) 
	(assert (roman proserpina)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddes)) 
	(bind ?name-g (upcase persephone)) 
	(bind ?name-r (upcase proserpina)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans she was known as %s" ?name-r) 
	(assert (parents-of persephone)) 
	(assert (children-of persephone)) 
	(printout t crlf crlf)
)


(defrule cronus ""
	(in-name ?in) 
	(or (in-name cronus ) 
	    (in-name saturn )) 
	=>
	(assert (entity titan cronus)) 
	(assert (greek cronus)) 
	(assert (roman saturn)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase titan)) 
	(bind ?name-g (upcase Cronus)) 
	(bind ?name-r (upcase saturn)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans he was known as %s" ?name-r) 
	(assert (parents-of cronus)) 	
	(assert (children-of cronus)) 
	(printout t crlf Crlf)) 


(defrule helios ""
	(in-name ?in) 
	(or (in-name helios )
	     (in-name sol )) 
	=>
	(assert (entity god helios )) 
	(assert (greek helios)) 
	(assert (roman sol)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase helios)) 
	(bind ?name-r (upcase sol)) 
	(format t "The name you entered, %s, is is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans he was known as %s" ?name-r) 
	(assert (parents-of helios)) 
	(assert (children-of helios)) 
	(printout t crlf crlf)) 


(defrule gaea ""
	(in-name ?in) 
	(or (in-name gaea) 
	    (in-name terra)) 
	=>
	(assert (entity pre-god gaea)) 
	(assert (greek gaea)) 
	(assert (roman terra)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase pre-titan)) 
	(bind ?name-g (upcase gaea)) 
	(bind ?name-r (upcase terra)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t " while to the Romans she was known as %s" ?name-r) 
	(assert (parents-of gaea)) 
	(assert (children-of gaea)) 
	(printout t crlf crlf)) 


(defrule hecate ""
	(in-name ?in) 
	(or (in-name hecate) 
	    (in-name trivia)) 
	=>
	(assert (entity titan hecate)) 
	(assert (greek hecate)) 
	(assert (roman trivia)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase titan)) 
	(bind ?name-g (upcase hecate)) 
	(bind ?name-r (upcase trivia)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "She was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans she was known as %s" ?name-r) 
	(assert (parents-of hecate)) 
	(assert (chitdren-of hecate)) 
	(printout t crlf crlf)) 


(defrule odysseus ""
	(in-name ?in) 
	(or (in-name odysseus) 
	    (in-name ulysses)
	) 
	=> 
	(assert (entity human odysseus)) 
	(assert (greek odysseus)) 
	(assert (roman ulysses)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase human)) 
	(bind ?name-g (upcase odysseus)) 
	(bind ?name-r (upcase ulysses)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He was known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans he was known as %s" ?name-r) 
	(assert (parents-of odysseus)) 
	(assert (children-of odysseus)) 
	(printout t crlf crlf)
) 


(defrule hestia ""
	(in-name ?in) 
	(or (in-name hestia) 
	    (in-name vesta)
	)
	=> 
	(assert (entity goddess hestia )) 
	(assert (greek hestia)) 
	(assert (roman vesta)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g (upcase hestia)) 
	(bind ?name-r (upcase vestal)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "she is known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "while to the Romans she is known as %s" ?name-r) 
	(assert (parents-of hestia)) 
	(assert (children-of hestia)) 
	(printout t crlf crlf)
) 


(defrule aphrodite ""
	(in-name ?in) 
	(or (in-name aphrodite) 
	(in-name aphrodite-urania) 
	(in-name aphrodite-pandemos) 
	(in-name venus)) 
	=>
	(assert (entity goddess aphrodite ))
	(assert (greek aphrodite-urania)) 
	(assert (greek aphrodite-pandemos)) 
	(assert (greek aphrodite)) 
	(assert (roman venus)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase goddess)) 
	(bind ?name-g1 (upcase aphrodite)) 
	(bind ?name-g2 (upcase aphrodite-urania)) 
	(bind ?name-g3 (upcase aphrodite-pandemos)) 
	(bind ?name-r (upcase venus)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "she is known to the Greeks as %s, %s and %s" ?name-g1 ?name-g2 ?name-g3) 
	(printout t crlf)
	(format t "while to the Romans she is known as %s" ?name-r) 
	(assert (parents-of aphrodite)) 
	(assert (children-of aphrodite)) 
	(printout t crlf crlf)) 

(defrule hephaistos ""
	(in-name ?in) 
	(or (in-name hephaistos) 
	    (in-name vulcan)) 
	=>
	(assert (entity god hephaistos)) 
	(assert (greek hepaistos)) 
	(assert (roman vulcan)) 
	(bind ?query (upcase ?in)) 
	(bind ?entity-g (upcase god)) 
	(bind ?name-g (upcase hepaistos))
	(bind ?name-r (upcase vutcan)) 
	(format t "The name you entered, %s, is a %s" ?query ?entity-g) 
	(printout t crlf) 
	(format t "He fs known to the Greeks as %s" ?name-g) 
	(printout t crlf) 
	(format t "and to the Romans as %s" ?name-r) 
	(assert (parents-of hepaistos)) 
	(assert (children-of hepaistos)) 
	(printout t crlf crlf)) 


;;; ***********
;;; family
;;; ***********

(defrule father-of ""
	(father-of ?in) 
	(person (child ?in)(father ?dad)(mother ?mom)) 
	=>
	(bind ?in (upcase ?in)) 
	(bind ?dad (upcase ?dad)) 
	(format t "The father of %s was %s" ?in ?dad) 
	(printout t crlf)) 

(defrule mother-of ""
	(mother-of ?in) 
	(person (child ?in)(father ?dad)(mother ?mom)) 
	=>
	(bind ?in (upcase ?in)) 
	(bind ?mom (upcase ?mom)) 
	(format t "The mother of %s was %s" ?in ?mom) 
	(printout t crlf)) 

(defrule parents-of ""
	(parents-of ?in) 
	(person (child ?in)(father ?dad)(mother ?mom)) 
	=>
	(bind ?in (upcase ?in)) 
	(bind ?dad (upcase ?dad)) 
	(bind ?mom (upcase ?mom)) 
	(format t "The mother and father of %s were %s and %s" ?in ?mom ?dad ) 
	(printout t crlf )) 


(defrule children-of ""
	(children-of ?in) 
	(or 
		(person (child ?kid)(father ?in)(mother ?mate)) 
		(person (child ?kid)(father ?mate)(mother ?in))) 
	=> 
	(bind ?in (upcase ?in)) 
	(bind ?mate (upcase ?mate)) 
	(bind ?kid (upcase ?kid)) 
	(format t "When %s mated with %s, %s was born" ?in ?mate ?kid) 
	(printout t crlf)) 


;;; ***********
;;; birth
;;; ***********

(defrule birth-of-others "Prints all other births"
	(birth-of ?in)
	(person (child ?in)(father ?dad)(mother ?mom))
	=>
	(bind ?in (upcase ?in))
	(bind ?dad (upcase ?dad))
	(bind ?mom (upcase ?mom))
	(format t "%s was born to %s and %s" ?in ?dad ?mom)
	(printout t crlf)
)

(defrule birth-of-athena "Prints birth of Athena"
	(birth-of athena)
	(person (child athena)(father zeus)(mother no-one))
	=>
	(printout t "ATHENA emerged from ZEUS's head after he swallowed his wife, Metis" crlf)
)

(defrule birth-of-eumenidies "Prints birth of the Eumenidies"
	(birth-of eumenidies)
	(person (child eumenidies)(father ouranos)(mother none))
	=>
	(printout t "The EUMENIDIES were created when OURANOS's genitals fell into the sea" crlf)
)

(defrule birth-of-ouranos "Prints birth of Ouranos"
	(birth-of ouranos)
	(person (child ouranos)(father none)(mother gaea))
	=>
	(printout t "OURANOS was conceived through GAEA alone" crlf)
)


;;; ***********
;;; death
;;; ***********

(defrule death-of-aias "Prints death of Aias"
	(death-of aias)
	(person (child aias)(father telemon)(mother unknown))
	=>
	(printout t "AIAS commited suicide by sword when ODYSSEUS received Achilles's armor instead of him" crlf)
)

(defrule death-of-asklepios "Prints death of Asklepios"
	(death-of asklepios)
	(person (child asklepios)(father apollo)(mother koronis))
	=>
	(printout t "ASKLEPIOS was killed by ZEUS, as his power to bring people back from the underworld was considered too great" crlf)
)

(defrule death-of-dionysus "Prints death of Dionysus"
	(death-of dionysus)
	(person (child dionysus)(father zeus)(mother semele))
	=>
	(printout t "DIONYSUS was killed by the Titans but brought back to life by Rhea" crlf)
)

(defrule death-of-heracles "Prints death of Heracles"
	(death-of heracles)
	(person (child heracles)(father zeus)(mother alcmene))
	=>
	(printout t "HERACLES was poisoned by his wife Deianira and voluntarily burned on a funeral pyre by his friend Poeas" crlf)
	(printout t "HERACLES became a deity on Olympus after death" crlf)
)

(defrule death-of-odysseus "Prints death of Odysseus"
	(death-of odysseus)
	(person (child odysseus)(father laertes)(mother unknown))
	=>
	(printout t "ODYSSEUS was killed by his son Telegonus" crlf)
)

(defrule death-of-memnon "Prints death of Memnon"
	(death-of memnon)
	(person (child memnon)(father tithonus)(mother eos))
	=>
	(printout t "MEMNON was killed by Achilles" crlf)
)

(defrule death-of-ethiopia "Prints death of Ethiopia"
	(death-of ethiopia)
	(person (child ethiopia)(father tithonus)(mother eos))
	=>
	(printout t "ETHIOPIA was killed by HERACLES" crlf)
)


;;; ***********
;;; events
;;; ***********

(defrule events-aias "Prints Aias's life events"
	(events aias)
	(person (child aias)(father telemon)(mother unknown))
	=>
	(printout t "AIAS dueled Hector in the Trojan War" crlf)
)

(defrule events-apollo "Prints Apollo's life events"
	(events apollo)
	(person (child apollo)(father zeus)(mother leto))
	=>
	(printout t "APOLLO defeated the dragon Python" crlf)
)

(defrule events-ares "Prints Ares's life events"
	(events ares)
	(person (child ares)(father zeus)(mother hera))
	=>
	(printout t "ARES was wounded by Diomedes" crlf)
	(printout t "ARES was defeated twice by HERACLES" crlf)
)

(defrule events-artemis "Prints Artemis's life events"
	(events artemis)
	(person (child artemis)(father zeus)(mother leto))
	=>
	(printout t "ARTEMIS helped LETO birth APOLLO" crlf)
)

(defrule events-asklepios "Prints Asklepios's life events"
	(events asklepios)
	(person (child asklepios)(father apollo)(mother koronis))
	=>
	(printout t "ASKLEPIOS healed and received knowledge from a snake" crlf)
)

(defrule events-cronus "Prints Cronus's life events"
	(events cronus)
	(person (child cronus)(father ouranos)(mother gaea))
	=>
	(printout t "CRONUS castrated his father, OURANOS" crlf)
	(printout t "CRONUS swallowed all of his children except for ZEUS" crlf)
	(printout t "CRONUS was imprisoned in Tartarus by ZEUS" crlf)
)

(defrule events-demeter "Prints Demeter's life events"
	(events demeter)
	(person (child demeter)(father cronus)(mother rhea))
	=>
	(printout t "DEMETER's daughter, PERSEPHONE, was taken by HADES" crlf)
)

(defrule events-dionysus "Prints Dionysus's life events"
	(events dionysus)
	(person (child dionysus)(father zeus)(mother semele))
	=>
	(printout t "DIONYSUS brought his mother, Semele, back from the underworld" crlf)
)

(defrule events-eos "Prints Eos's life events"
	(events eos)
	(person (child eos)(father hyperion)(mother theia))
	=>
	(printout t "EOS was cursed with insatiable lust by APHRODITE" crlf)
)

(defrule events-eros "Prints Eros's life events"
	(events eros)
	(person (child eros)(father unknown)(mother aphrodite))
	=>
	(printout t "EROS shot himself with his own arrow and fell in love with Psyche" crlf)
)

(defrule events-gaea "Prints Gaea's life events"
	(events gaea)
	(person (child gaea)(father chaos)(mother none))
	=>
	(printout t "GAEA tried to overthrow ZEUS" crlf)
)

(defrule events-hades "Prints Hades's life events"
	(events hades)
	(person (child hades)(father cronus)(mother rhea))
	=>
	(printout t "HADES kidnapped DEMETER's daughter, PERSEPHONE" crlf)
)

(defrule events-hera "Prints Hera's life events"
	(events hera)
	(person (child hera)(father cronus)(mother rhea))
	=>
	(printout t "HERA was tricked by ZEUS into marriage" crlf)
	(printout t "HERA sent the dragon Python to kill LETO" crlf)
)

(defrule events-heracles "Prints Heracles's life events"
	(events heracles)
	(person (child heracles)(father zeus)(mother alcmene))
	=>
	(printout t "HERACLES defeated the Lion of Mount Cithaeron" crlf)
	(printout t "HERACLES completed twelve labors for Eurystheus" crlf)
)

(defrule events-hermes "Prints Hermes's life events"
	(events hermes)
	(person (child hermes)(father zeus)(mother maia))
	=>
	(printout t "HERMES Beheaded the Argus Panoptes" crlf)
	(printout t "HERMES Guided PERSEPHONE back to DEMETER" crlf)
)

(defrule events-leto "Prints Leto's life events"
	(events leto)
	(person (child leto)(father coeus)(mother phoebe))
	=>
	(printout t "LETO was forbidden by HERA to give birth on solid ground" crlf)
	(printout t "LETO was chased by the dragon Python, sent by HERA" crlf)
)

(defrule events-moirai "Prints the Moirai's life events"
	(events moirai)
	(person (child moirai)(father zeus)(mother themis))
	=>
	(printout t "The MOIRAI were deceived by APOLLO to save Admetus" crlf)
)

(defrule events-odysseus "Prints Odysseus's life events"
	(events odysseus)
	(person (child odysseus)(father laertes)(mother unknown))
	=>
	(printout t "ODYSSEUS fought in the Trojan War" crlf)
	(printout t "ODYSSEUS divised the plan of the Trojan Horse" crlf)
	(printout t "ODYSSEUS defeated the Cyclops Polyphemus" crlf)
)

(defrule events-ouranos "Prints the Ouranos's life events"
	(events ouranos)
	(person (child ouranos)(father none)(mother gaea))
	=>
	(printout t "OURANOS was castrated by his son, CRONUS" crlf)
)

(defrule events-pan "Prints the Pan's life events"
	(events pan)
	(person (child pan)(father hermes)(mother unknown))
	=>
	(printout t "PAN created the syrinx instrument" crlf)
)

(defrule events-persephone "Prints the Persephone's life events"
	(events persephone)
	(person (child persephone)(father zeus)(mother demeter))
	=>
	(printout t "PERSEPHONE was abducted by HADES to be his wife" crlf)
)

(defrule events-polydueces "Prints the Polydueces' life events"
	(events polydueces)
	(person (child polydueces)(father zeus)(mother leda))
	=>
	(printout t "The POLYDUECES aided Jason in the quest for the Golden Fleece" crlf)
	(printout t "The POLYDUECES saved their sister, Helen, from Theseus" crlf)
)

(defrule events-poseidon "Prints Poseidon's life events"
	(events poseidon)
	(person (child poseidon)(father cronus)(mother rhea))
	=>
	(printout t "POSEIDON, along with APOLLO, built the walls of Troy as punishment for challenging ZEUS" crlf)
)

(defrule events-zeus "Prints Zeus's life events"
	(events zeus)
	(person (child zeus)(father cronus)(mother rhea))
	=>
	(printout t "ZEUS was saved by Rhea from being eaten by CRONUS" crlf)
	(printout t "ZEUS saved his siblings from CRONUS" crlf)
	(printout t "ZEUS overthrew the Titans" crlf)
)

(defrule events-memnon "Prints Memnon's life events"
	(events memnon)
	(person (child memnon)(father tithonus)(mother eos))
	=>
	(printout t "MEMNON fought for the Trojans in the Trojan War" crlf)
	(printout t "MEMNON killed Antilochos" crlf)
)


;;; ******************* 
;;; name the gods/irrmortals/etc
;;; ******************* 

 
(defrule name-the-gods ""
	(name-the-gods) 
	(god (greek ?name) (fame ?assoc)) 
	=>
	(bind ?name (upcase ?name)) 
	(printout t crlf) 
	(format t "%s :" ?name )
	(printout t crlf crlf))
 
(defrule name-a-god ""
	(greek ?name) 
	(god (greek ?name)(fame ?assoc)) 
	=>
	(bind ?name (upcase ?name)) 
	(printout t crlf) 
	(format t "%s :" ?name )
	(printout t crlf crlf) 
	(format t "%s" ?assoc) 
	(printout t crlf crlf)) 


;;; ******************* 
;;; honors 
;;;******************* 

(defrule honors-planet "" 
	(honors ?in) 
	(or (celestial-body-r (roman ?in)(planet ?body)) 
	(celestial-body-g (greek ?in)(planet ?body))) 
	=>
	(bind ?in (upcase ?in)) 
	(printout t crlf crlf crlf) 
	(format t "There is a planet named %s" ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) 
	(printout t crlf crlf)) 

(defrule honors-stars "" 
	(honors ?in) 
	(constellation (roman ?in)(stars ?body)) 
	=>
	(bind ?in (upcase ?in)) 
	(printout t crlf crlf crlf) 
	(format t "There is a constellation named %s" ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) 	
	(printout t crlf crlf))

 
(defrule honors-place "" 
	(honors ?in) 
	(celestial-place (roman ?in)(place ?body)) 
	=>
	(bind ?in (upcase ?in))
	(printout t crlf crlf crlf) 
	(format t "There is a place named %s" ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) (printout t crlf crlf)) 


;;; ******************* 
;;; the skys
;;; ******************* 

(defrule the-planets-r "" 
	(roman ?in)
	(celestial-body-r (roman ?in)(planet ?body)) 
	(greek ?g-in) 
	=>
	(bind ?g-in (upcase ?g-in)) 
	(bind ?in (upcase ?in)) 
	(printout t crlf crlf crlf) 
	(format t "%s has a planet named under the Roman name %s" ?g-in ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) 
	(printout t crlf crlf)
) 

(defrule the-planets-g "" 
	(greek ?in) 
	(celestial-body-g (greek ?in)(planet ?body)) 
	=>
	(bind ?in (upcase ?in)) 
	(printout t crlf crlf crlf) 
	(format t "There is a planet/asteriod named %s" ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) 
	(printout t crlf crlf)
) 

(defrule the-stars ""
	(roman ?in) 
	(constellation (roman ?in)(stars ?body)) 
	(greek ?g-in) 
	=>
	(bind ?g-in (upcase ?g-in)) 
	(bind ?in (upcase ?in)) 
	(printout t crlf crlf crlf) 
	(format t "%s has a constellation named under the Roman name %s" ?g-in ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) 
	(printout t crlf crlf)
) 
	
(defrule sky-places "" 
	(roman ?in) 
	(celestial-place (roman ?in) (place ?body)) 
	(greek ?g-in)
	=> 
	(bind ?g-in (upcase ?g-in)) 
	(bind ?in (upcase ?in)) 
	(printout t crlf crlf crlf) 
	(format t "%s has a place named under the Roman name %s" ?g-in ?in) 
	(printout t crlf crlf) 
	(format t "%s" ?body) 
	(printout t crlf crlf)
) 

;;; ******************* 
;;;  program start
;;; ******************* 
 
(defrule startup "the beginning!" 
	(declare (salience 100)) 
	=>
	(printout t crlf  crlf) 
	(printout t crlf "Welcome to Ancient Greece" ) 
	(printout t crlf "A place where you can't tell the players without a score card" )
	(printout t crlf "I am Mythos, your guide" )
	(printout t crlf crlf crlf )
) 

(defrule ask-mythos "inputs the first 'name' to be found" 
	(declare (salience -10)) 
	(not (in-name ?)
	) 
	=> 
	(printout t "Ask me of ancient Greece mythology and I will consult"  crlf ) 
	(printout t "the Oracle at Delphi and answer your question"  crlf ) 
	(printout t "Simply enter one of the following conmands:" crlf) 
	(printout t "identify <name> (of the person you wish info on)"  crlf ) 
	(printout t "name-the-gods"  crlf ) 
	(printout t "father-of <name>"  crlf ) 
	(printout t "mother-of <name>"  crlf ) 
	(printout t "parents-of <name>"  crlf ) 
	(printout t "children-of <name>"   crlf ) 
	(printout t "birth-of <name>"   crlf )
	(printout t "death-of <name>"   crlf )
	(printout t "events <name>"  crlf )
	(printout t "honors <name>"  crlf ) 
	(printout t "PS. I do require correct spelling as many have very similar names"  crlf ) 
	(printout t crlf )
	(printout t "enter the command you wish to execute" crlf) 
	(bind ?USER-IN1 (readline))
	;(reset)  ; This fix did not work on my computer in either 6.31 or 6.4
	;(run)
	(assert-string (str-cat "(" ?USER-IN1 ")" ))
	(printout t crlf crlf)
	
) 


(defrule reset-mythos "" 
	(declare (salience -100)) 
	=> 
	(printout t crlf crlf)
	(printout t crlf crlf)
	(printout t "Reseting Mythos to answer more questions" crlf) 
	(printout t "type CTRL+SHIFT+H and a 'enter key' to quit" crlf) 
	(reset) 
	(run)
) 
