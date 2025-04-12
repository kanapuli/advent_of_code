package solver

import (
	"errors"
	"fmt"
	"strings"
)

type DayOne struct {
	BaseSolver
}

var _ PuzzleSolver = DayOne{}

func NewDayOneSolver() DayOne {
	return DayOne{
		BaseSolver: BaseSolver{
			name: "Day One Solver",
			day:  1,
		},
	}
}

// SolvePart01 implements the solution for the first puzzle
func (d DayOne) SolvePart01(puzzle string) (string, error) {
	chars := strings.Split(puzzle, "")
	upFloor, downFloor := 0, 0
	for _, c := range chars {
		switch c {
		case ")":
			downFloor += 1
		case "(":
			upFloor += 1
		default:
			return "", errors.New("invalid character in the input")
		}
	}
	return fmt.Sprintf("%d", upFloor-downFloor), nil
}

// SolvePart02 implements .the solution for the second puzzle
// Finds the position of the character when santa enter basement '-1'
func (d DayOne) SolvePart02(puzzle string) (string, error) {
	floor := 0
	chars := strings.Split(puzzle, "")
	for i, c := range chars {
		switch c {
		case ")":
			floor = floor - 1
		case "(":
			floor = floor + 1
		default:
			return "", errors.New("invalid character in the input")
		}
		if floor == -1 {
			return fmt.Sprintf("%d", i+1), nil
		}
	}
	return fmt.Sprintf("%d", -1), errors.New("santa never got to basement -1")
}
