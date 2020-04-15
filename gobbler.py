import enum

class Color(enum.Enum):
    WHITE = 790
    BLACK = 0

class Tile:
    def __init__(self, size, color):
        self.size = size
        self.color = color

    def __str__(self):
        return chr(9311 + self.size + self.color.value)

class Square:
    def __init__(self, x, y):
        self.x, self.y = x, y
        self.tiles = []

class Board:
    def __init__(self, size=4):
        self.board = [[Square(x, y) for x in range(size)] for y in range(size)]
        self.size = size


class Player:
    def __init__(self, size, color, stacks=3):
        self.color = color
        self.stacks = [[Tile(i, color) for i in range(1, size + 1)] for i in range(stacks)]

class Game:
    def __init__(self, size=4):
        self.board = Board(size=size)
        self.players = [Player(size, i) for i in Color]

