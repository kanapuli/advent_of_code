package main

import (
	"fmt"
	"os"

	"github.com/kanapuli/adventofcode2015/input"
	"github.com/kanapuli/adventofcode2015/solver"
)

const (
	puzzlePath = "puzzles"
)

func main() {
	dayOneSolver := solver.NewDayOneSolver()

	solvers := []solver.PuzzleSolver{
		dayOneSolver,
	}

	for _, s := range solvers {
		puzzle, err := input.ReadPuzzleForTheDay(puzzlePath, s.GetDay())
		if err != nil {
			fmt.Errorf("error while reading puzzle file for the day: %d", s.GetDay())
			os.Exit(1)
		}

		partOneSolution, err := s.SolvePart01(puzzle)
		if err != nil {
			fmt.Errorf("error while solving part01 puzzle for %s, day: %d, err: %v", s.GetName(), s.GetDay(), err)
		}
		fmt.Printf("%s Output for part01: %v\n", s.GetName(), partOneSolution)

		partTwoSolution, err := s.SolvePart02(puzzle)
		if err != nil {
			fmt.Errorf("error while solving part02 puzzle for %s, day: %d, err: %v", s.GetName(), s.GetDay(), err)
		}
		fmt.Printf("%s Output for part02: %v\n", s.GetName(), partTwoSolution)
	}

}
