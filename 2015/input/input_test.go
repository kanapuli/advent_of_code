package input_test

import (
	"testing"

	"github.com/kanapuli/adventofcode2015/input"
	"github.com/stretchr/testify/assert"
)

func TestReadPuzzleForTheDay(t *testing.T) {
	puzzle, err := input.ReadPuzzleForTheDay("../puzzles", 1)
	assert.Nil(t, err)
	assert.NotEmpty(t, puzzle)
}
