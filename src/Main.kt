fun defTotal(defPerso:Int,armure:Int,rarete:Int):Int{
    return defPerso+armure+rarete
}

fun lanceDes(nbDe:Int,nbFaces:Int):Int{
    //val rnds = (0..10).random()  generated random from 0 to 10 included
    val res = (nbDe..nbFaces*nbDe).random()
    return res
}

fun calculDegat(nbDes:Int,nbFaces: Int,bonusQualite:Int,actCrit:Int,multipliCrit:Int):Int{
    val des = lanceDes(nbDes,nbFaces)
    var res=0
    if (des>=actCrit){
        res = des*multipliCrit+bonusQualite
    }else{
        res = des+bonusQualite
    }
    return res
}

fun attack(degatAttack:Int,attaquant:String,victim:String,pvVictim:Int,defVictim:Int,){
    var dammage = degatAttack-defVictim
    var pv = pvVictim
    if (dammage<0){
        dammage=0
    }
    pv -=dammage

    if (pv<0){
        pv=0
    }
    println("$attaquant attaque $victim et lui fait $dammage degats. il reste $pv a $victim")
}

fun boirepotion(nomPerso:String,pv:Int,pvMax:Int,statPot:Int){
    var gain = pv+statPot
    if (gain>pvMax){
        gain=pvMax
    }
    println("$nomPerso se heal et gagne $statPot de vie.   pv : $gain / $pvMax")
}

fun katon(nomCaster:String,victim: String,attack:Int,defVictim: Int,pvVictim: Int){
    val degat = lanceDes(attack/3,6)
    var pvLost = pvVictim-(degat-defVictim)
    if (pvLost<0){
        pvLost=0
    }
    println("$nomCaster lance un katon sur $victim. $victim recois $degat de degat il lui reste $pvLost de vie")


}

fun missilMagic(nomCaster: String,victim: String,attack:Int,defVictim: Int,pvVictim: Int) {
    var duree = 0
    while (duree < attack / 2) {
        val degat = lanceDes(1, 6)
        var pvLost = pvVictim - (degat - defVictim)
        if (pvLost < 0) {
            pvLost = 0
            break
        }
        duree += 1
        println("$nomCaster lance un missile magique sur $victim. $victim recois $degat de degat il lui reste $pvLost de vie")
    }


}

fun invocArme(nomCaster: String,typeWeap:String){
    val de = lanceDes(1,20)
    var qualite:String=""
    if (de<5){
        qualite="comm"
    }else if (de>=5 && de<10){
        qualite="rare"
    }else if (de>=10 && de<15){
        qualite="epic"
    }else{
        qualite="legend"
    }

    println("$nomCaster invoque un(e) $typeWeap $qualite")

}

fun heal (nomCaster: String,victim: String,attack: Int,pvVictim: Int,pvMax: Int,zomie:Boolean){
    val soin = attack/2
    var pv = pvVictim
    if (zomie==true){
        pv += -soin
    }else{
        pv += soin
    }
    if (pv < 0) {
        pv = 0
    }
    if (pv>pvMax){
        pv=pvMax
    }
    println("$nomCaster heal $victim, il recupere $soin de vie. $pv/$pvMax pv ")
}

fun afficherInventaire(nomPerso: String,inventaire:MutableList<String>){
    println("inventaire de $nomPerso")
    for (i in inventaire.indices){
        print("$i : ")
        println(inventaire[i])
    }
}

fun choisirItem(nomPerso: String,inventaire: MutableList<String>){
    afficherInventaire(nomPerso,inventaire)
    println("choisissez un item ")
    val reponse = readln()
    while (reponse in inventaire == false){
        println("choisissez un item correcte")
       val reponse = readln()
    }
    println("$reponse ...c'est un choix intérressant")
}

tourJouer()



fun main() {
    //println(lanceDes(6,6))
    //println(calculDegat(4,6,5,4,8))
    //attack(calculDegat(4,6,70,4,50),"sukuna","go       jo", 100,defTotal(10 ,2,5))
    //boirepotion("hakari",100,1000,999)
    //katon("madara","toutlemondeshinobi",calculDegat(3,6,1000,3,1000000),defTotal(100,10,100),10000)
    //missilMagic("renala","tarnished",calculDegat(1,6,100,3,1000),defTotal(100,130,100),1000000)
    //invocArme("erza","epee")
    //heal("lucio","rein",100,500,800,false)
    //afficherInventaire("tarnished", mutableListOf("potion vie","potion de mana","torrent","runes"))
    //choisirItem("tarnished", mutableListOf("potion vie","potion de mana","torrent","runes"))


}