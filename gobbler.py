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

    def empty(self):
        return not self.tiles

    def add_tile(self, tile):
        self.tiles.append(tile)

    def __str__(self):
        return str(self.tiles[-1]) if self.tiles else " "

class Board:
    def __init__(self, size=4):
        self.board = [[Square(x, y) for x in range(size)] for y in range(size)]
        self.size = size

    def __str__(self):
        a, t = "|\n", "--"*self.size + "-"
        return t + a[-1] + a.join(["".join(a[0] + str(sq) for sq in row) for row in self.board]) + a + t

class Player:
    def __init__(self, size, color, stacks=3):
        self.color = color
        self.stacks = [[Tile(i, color) for i in range(1, size + 1)] for i in range(stacks)]

class Game:
    def __init__(self, size=4):
        self.board = Board(size=size)
        self.players = [Player(size, i) for i in Color]

        self.board.board[0][1].add_tile(Tile(2, Color.BLACK))
        self.board.board[0][1].add_tile(Tile(3, Color.BLACK))
        self.board.board[0][0].add_tile(Tile(2, Color.WHITE))


print(Game().board)
