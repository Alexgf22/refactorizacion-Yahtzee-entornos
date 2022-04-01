import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class YahtzeeTest {

    @Test
    fun chance()
    {
        val expected = 15
        val actual = Yahtzee_refactorizado.chance(2,3,4,5,1)
        assert(expected == actual)
        assert (16 == Yahtzee_refactorizado.chance(3,3,4,5,1))
    }

    @Test
    fun yahtzee()
    {
        val expected = 50
        val actual = Yahtzee_refactorizado.yahtzee(listOf(4,4,4,4,4))
        assert( expected == actual)
        assert( 50 == Yahtzee_refactorizado.yahtzee(listOf(6,6,6,6,6)))
        assert( 0 == Yahtzee_refactorizado.yahtzee(listOf(6,6,6,6,3)))
    }

    @Test
    fun ones()
    {
        assert (Yahtzee_refactorizado.ones(1,2,3,4,5) == 1)
        assert (2 == Yahtzee_refactorizado.ones(1,2,1,4,5))
        assert (0 == Yahtzee_refactorizado.ones(6,2,2,4,5))
        assert (4 == Yahtzee_refactorizado.ones(1,2,1,1,1))
    }

    @Test
    fun twos()
    {   assert( 4 == Yahtzee_refactorizado.twos(1,2,3,2,6))
        assert(10 == Yahtzee_refactorizado.twos(2,2,2,2,2))
    }

    @Test
    fun threes()
    {   assert (6 == Yahtzee_refactorizado.threes(1,2,3,2,3))
        assert (12 == Yahtzee_refactorizado.threes(2,3,3,3,3))
    }

    @Test
    fun fours()
    {
        assert (12 == Yahtzee_refactorizado(4,4,4,5,5).fours())
        assert (8 == Yahtzee_refactorizado(4,4,5,5,5).fours())
        assert (4 == Yahtzee_refactorizado(4,5,5,5,5).fours())
    }

    @Test
    fun fives()
    {
        assert (10 == Yahtzee_refactorizado(4,4,4,5,5).fives())
        assert (15 == Yahtzee_refactorizado(4,4,5,5,5).fives())
        assert (20 == Yahtzee_refactorizado(4,5,5,5,5).fives())
    }

    @Test
    fun sixes()
    {
        assert (0 == Yahtzee_refactorizado(4,4,4,5,5).sixes())
        assert (6 == Yahtzee_refactorizado(4,4,6,5,5).sixes())
        assert (18 == Yahtzee_refactorizado(6,5,6,6,5).sixes())
    }


    @Test
    fun score_pair()
    {
        assert (6 == Yahtzee_refactorizado.score_pair(3,4,3,5,6))
        assert (10 == Yahtzee_refactorizado.score_pair(5,3,3,3,5))
        assert (12 == Yahtzee_refactorizado.score_pair(5,3,6,6,5))
    }

    @Test
    fun two_pair()
    {
        assert (16 == Yahtzee_refactorizado.two_pair(3,3,5,4,5))
        assert (18 == Yahtzee_refactorizado.two_pair(3,3,6,6,6))
        assert (0 == Yahtzee_refactorizado.two_pair(3,3,6,5,4))
    }

    @Test
    fun three_of_a_kind()
    {
        assert (9 == Yahtzee_refactorizado.three_of_a_kind(3,3,3,4,5))
        assert (15 == Yahtzee_refactorizado.three_of_a_kind(5,3,5,4,5))
        assert (9 == Yahtzee_refactorizado.three_of_a_kind(3,3,3,3,5))

    }

    @Test
    fun four_of_a_kind()
    {
        assert (12 == Yahtzee_refactorizado.four_of_a_kind(3,3,3,3,5))
        assert (20 == Yahtzee_refactorizado.four_of_a_kind(5,5,5,4,5))
        assert (12 == Yahtzee_refactorizado.four_of_a_kind(3,3,3,3,3))
        assert (0  == Yahtzee_refactorizado.four_of_a_kind(3,3,3,2,1))
    }


    @Test
    fun smallStraight()
    {
        assert (15 == Yahtzee_refactorizado.smallStraight(1,2,3,4,5))
        assert (15 == Yahtzee_refactorizado.smallStraight(2,3,4,5,1))
        assert (0 == Yahtzee_refactorizado.smallStraight(1,2,2,4,5))
    }

    @Test
    fun largeStraight()
    {
        assert (20 == Yahtzee_refactorizado.largeStraight(6,2,3,4,5))
        assert (20 == Yahtzee_refactorizado.largeStraight(2,3,4,5,6))
        assert (0 == Yahtzee_refactorizado.largeStraight(1,2,2,4,5))
    }

    @Test
    fun fullHouse()
    {
        assert (18 == Yahtzee_refactorizado.fullHouse(6,2,2,2,6))
        assert (0 == Yahtzee_refactorizado.fullHouse(2,3,4,5,6))
    }
}