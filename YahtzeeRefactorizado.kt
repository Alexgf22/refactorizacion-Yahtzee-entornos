class YahtzeeRefactorizado//dice= mutableListOf(d1,d2,d3,d4,d5,d6)
    (d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) {
    private var dice:MutableList<Int> = MutableList(6){0}

    init {
        dice[0]=d1
        dice[1]=d2
        dice[2]=d3
        dice[3]=d4
        dice[4]=d5
    }

    companion object
    {
        @JvmStatic
        fun chance(d1:Int, d2:Int, d3:Int, d4:Int, d5:Int): Int
        {   var total = 0
            var lista = arrayListOf(d1,d2,d3,d4,d5)
            total += reduce(lista)
            return total
        }

        @JvmStatic
        fun yahtzee(dice:List<Int>):Int
        {   val counts= MutableList(dice.size+1){0}
            for(die in dice)
            {
                counts[die-1]+=1
            }

            for(i in 0 until counts.size)
                if(counts[i]==5)
                    return 50

            return 0
        }

        @JvmStatic
        fun ones(d1:Int,d2:Int, d3:Int, d4:Int, d5:Int):Int
        {   var sum = 0
            val dados = listOf(d1, d2, d3, d4, d5).size*2
            var cuenta = dados.count(1)
            return cuenta * 1
        }

        @JvmStatic
        fun twos(d1:Int,d2:Int, d3:Int, d4:Int, d5:Int):Int
        {   var sum = 0
            val dados = listOf(d1, d2, d3, d4, d5).size*2
            var cuenta = dados.count(2)
            return cuenta * 2
        }

        @JvmStatic
        fun threes(d1:Int,d2:Int, d3:Int, d4:Int, d5:Int):Int
        {   var sum = 0
            val dados = listOf(d1, d2, d3, d4, d5).size*2
            var cuenta = dados.count(3)
            return cuenta * 3
        }

        @JvmStatic
        fun scorePair(d1:Int, d2:Int, d3:Int, d4:Int, d5:Int):Int
        {   val counts = MutableList(6){0}
            counts[d1-1] += 1
            counts[d2-1] += 1
            counts[d3-1] += 1
            counts[d4-1] += 1
            counts[d5-1] += 1
            var at=0
            for (at in 0 until 6)
                if (counts[6-at-1] >= 2)
                    return (6-at)*2
            return 0
        }

        @JvmStatic
        fun twoPair(d1:Int, d2:Int, d3:Int, d4:Int, d5:Int):Int
        {   val counts = MutableList(6){0}
            counts[d1 - 1] += 1
            counts[d2 - 1] += 1
            counts[d3 - 1] += 1
            counts[d4 - 1] += 1
            counts[d5 - 1] += 1
            var n = 0
            var score = 0
            for(i in 0 until 6)
                if (counts[6 - i - 1] >= 2)
                {
                    n += 1
                    score += (6 - i)
                }

            return if(n == 2)
                score * 2
            else
                0
        }

        @JvmStatic
        fun fourOfAKind(_1: Int, _2: Int, d3: Int, d4: Int, d5: Int):Int
        {
            val tallies = MutableList(6){0}
            tallies[_1-1] += 1
            tallies[_2-1] += 1
            tallies[d3-1] += 1
            tallies[d4-1] += 1
            tallies[d5-1] += 1
            for(i in 0 until 6)
                if (tallies[i] >= 4)
                    return (i+1) * 4
            return 0
        }

        @JvmStatic
        fun threeOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int):Int
        {
            val t = MutableList(6){0}
            t[d1-1] += 1
            t[d2-1] += 1
            t[d3-1] += 1
            t[d4-1] += 1
            t[d5-1] += 1
            for(i in 0 until 6)
                if (t[i] >= 3)
                    return (i+1) * 3
            return 0
        }

        @JvmStatic
        fun smallStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int):Int
        {
            val tallies =MutableList(6){0}

            /*for (dado in tallies) {
                tallies[dado - 1]
                tallies[dado - 1] += 1
            }*/
            tallies[d1-1] += 1
            tallies[d2-1] += 1
            tallies[d3-1] += 1
            tallies[d4-1] += 1
            tallies[d5-1] += 1
            if (tallies[0] == 1 && tallies[1] == 1 &&
                tallies[2] == 1 && tallies[3] == 1 &&
                tallies[4] == 1)
                return 15
            return 0
        }

        @JvmStatic
        fun largeStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int):Int
        {
            val tallies =MutableList(6){0}
            tallies[d1-1] += 1
            tallies[d2-1] += 1
            tallies[d3-1] += 1
            tallies[d4-1] += 1
            tallies[d5-1] += 1
            if (tallies[1] == 1 && tallies[2] == 1 &&
                tallies[3] == 1 && tallies[4] == 1 &&
                tallies[5] == 1 )
                return 20
            return 0
        }

        @JvmStatic
        fun fullHouse(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int):Int
        {
            val tallies =MutableList(6){0}
            var a2 = false
            var i = 0
            var at2 = 0
            var a3 = false
            var at3 = 0
            tallies[d1-1] += 1
            tallies[d2-1] += 1
            tallies[d3-1] += 1
            tallies[d4-1] += 1
            tallies[d5-1] += 1

            for(i in 0 until 6)
                if (tallies[i] == 2)
                {   a2 = true
                    at2 = i + 1
                }

            for(i in 0 until 6)
                if (tallies[i] == 3)
                {  a3 = true
                    at3 = i + 1
                }

            return if(a2 and a3)
                at2 * 2 + at3 * 3
            else
                0
        }
    }


    fun fours():Int
    {   var sum = 0
        for( at in 0 until 5)
            if(dice[at] == 4)
                sum += 4
        return sum
    }

    fun fives():Int
    {   var s = 0
        var i = 0
        for(i in 0 until dice.size)
            if (dice[i] == 5)
                s += 5
        return s
    }

    fun sixes():Int
    {
        var sum = 0
        for(at in 0 until dice.size)
            if (dice[at] == 6)
                sum += 6
        return sum
    }
}

private operator fun Any.times(i: Int): Int {

}

private fun Int.count(i: Int): Any {

}

