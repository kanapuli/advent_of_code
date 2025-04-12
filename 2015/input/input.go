package input

import (
	"fmt"
	"os"
	"path"
	"strings"
)

// ReadPuzzleForTheDay reads the puzzle input
// input: dir -> Directory where the puzzle input is stored
// input: day -> Day number for the puzzle
func ReadPuzzleForTheDay(dir string, day int) (string, error) {
	puzzleFile := path.Join(dir, fmt.Sprintf("%d.txt", day))
	b, err := os.ReadFile(puzzleFile)
	if err != nil {
		return "", err
	}
	puzzleInput := string(b)
	puzzleInput = strings.TrimSpace(puzzleInput)
	return puzzleInput, nil
}
