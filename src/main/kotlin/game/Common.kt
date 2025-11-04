package game

// 2차원 좌표
data class Point(val x: Int, val y: Int)

// 유닛 유형 (공격 가능/불가능 판별에 사용)
enum class UnitType {
    GROUND, AIR
}