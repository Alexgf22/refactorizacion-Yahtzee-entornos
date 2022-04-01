import org.junit.jupiter.api.Test

internal class YahtzeeTest {

    @Test
    fun chance()
    {
        val expected = 15
        val actual = YahtzeeRefactorizado.chance(2,3,4,5,1)
        assert(expected == actual)
        assert (16 == YahtzeeRefactorizado.chance(3,3,4,5,1))
    }

    @Test
    fun yahtzee()
    {
        val expected = 50
        val actual = YahtzeeRefactorizado.yahtzee(listOf(4,4,4,4,4))
        assert( expected == actual)
        assert( 50 == YahtzeeRefactorizado.yahtzee(listOf(6,6,6,6,6)))
        assert( 0 == YahtzeeRefactorizado.yahtzee(listOf(6,6,6,6,3)))
    }

    @Test
    fun ones()
    {
        assert (YahtzeeRefactorizado.ones(1,2,3,4,5) == 1)
        assert (2 == YahtzeeRefactorizado.ones(1,2,1,4,5))
        assert (0 == YahtzeeRefactorizado.ones(6,2,2,4,5))
        assert (4 == YahtzeeRefactorizado.ones(1,2,1,1,1))
    }

    @Test
    fun twos()
    {   assert( 4 == YahtzeeRefactorizado.twos(1,2,3,2,6))
        assert(10 == YahtzeeRefactorizado.twos(2,2,2,2,2))
    }

    @Test
    fun threes()
    {   assert (6 == YahtzeeRefactorizado.threes(1,2,3,2,3))
        assert (12 == YahtzeeRefactorizado.threes(2,3,3,3,3))
    }

    @Test
    fun fours()
    {
        assert (12 == YahtzeeRefactorizado(4,4,4,5,5).fours())
        assert (8 == YahtzeeRefactorizado(4,4,5,5,5).fours())
        assert (4 == YahtzeeRefactorizado(4,5,5,5,5).fours())
    }

    @Test
    fun fives()
    {
        assert (10 == YahtzeeRefactorizado(4,4,4,5,5).fives())
        assert (15 == YahtzeeRefactorizado(4,4,5,5,5).fives())
        assert (20 == YahtzeeRefactorizado(4,5,5,5,5).fives())
    }

    @Test
    fun sixes()
    {
        assert (0 == YahtzeeRefactorizado(4,4,4,5,5).sixes())
        assert (6 == YahtzeeRefactorizado(4,4,6,5,5).sixes())
        assert (18 == YahtzeeRefactorizado(6,5,6,6,5).sixes())
    }


    @Test
    fun scorePair()
    {
        assert (6 == YahtzeeRefactorizado.scorePair(3,4,3,5,6))
        assert (10 == YahtzeeRefactorizado.scorePair(5,3,3,3,5))
        assert (12 == YahtzeeRefactorizado.scorePair(5,3,6,6,5))
    }

    @Test
    fun twoPair()
    {
        assert (16 == YahtzeeRefactorizado.twoPair(3,3,5,4,5))
        assert (18 == YahtzeeRefactorizado.twoPair(3,3,6,6,6))
        assert (0 == YahtzeeRefactorizado.twoPair(3,3,6,5,4))
    }

    @Test
    fun threeOfAKind()
    {
        assert (9 == YahtzeeRefactorizado.threeOfAKind(3,3,3,4,5))
        assert (15 == YahtzeeRefactorizado.threeOfAKind(5,3,5,4,5))
        assert (9 == YahtzeeRefactorizado.threeOfAKind(3,3,3,3,5))

    }

    @Test
    fun fourOfAKind()
    {
        assert (12 == YahtzeeRefactorizado.fourOfAKind(3,3,3,3,5))
        assert (20 == YahtzeeRefactorizado.fourOfAKind(5,5,5,4,5))
        assert (12 == YahtzeeRefactorizado.fourOfAKind(3,3,3,3,3))
        assert (0  == YahtzeeRefactorizado.fourOfAKind(3,3,3,2,1))
    }


    @Test
    fun smallStraight()
    {
        assert (15 == YahtzeeRefactorizado.smallStraight(1,2,3,4,5))
        assert (15 == YahtzeeRefactorizado.smallStraight(2,3,4,5,1))
        assert (0 == YahtzeeRefactorizado.smallStraight(1,2,2,4,5))
    }

    @Test
    fun largeStraight()
    {
        assert (20 == YahtzeeRefactorizado.largeStraight(6,2,3,4,5))
        assert (20 == YahtzeeRefactorizado.largeStraight(2,3,4,5,6))
        assert (0 == YahtzeeRefactorizado.largeStraight(1,2,2,4,5))
    }

    @Test
    fun fullHouse()
    {
        assert (18 == YahtzeeRefactorizado.fullHouse(6,2,2,2,6))
        assert (0 == YahtzeeRefactorizado.fullHouse(2,3,4,5,6))
    }
}