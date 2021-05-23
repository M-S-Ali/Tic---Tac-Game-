# --------------------------------TIC TAC TOE GAME---------------------------------

import random

data = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
moves = set()


def printc(txt): print(f'\t\t\t\t\t{txt:^25}')


def game_board_printc():
    # printc('\n'*100)
    printc(' ' + f"{'_' * 7} " * 3)
    printc('|' + f"{' '*7}|"*3)
    printc(f"|   {data[0][0]}   |   {data[0][1]}   |   {data[0][2]}   |")  # data1
    printc('|' + f"{'_'*7}|"*3)
    printc('|' + f"{' '*7}|"*3)
    printc(f"|   {data[1][0]}   |   {data[1][1]}   |   {data[1][2]}   |")  # data2
    printc('|' + f"{'_'*7}|"*3)
    printc('|' + f"{' '*7}|"*3)
    printc(f"|   {data[2][0]}   |   {data[2][1]}   |   {data[2][2]}   |")  # data3
    printc('|' + f"{'_'*7}|"*3 + "\n")


def player_input_data_update(symbol):
    a, b = 0, 0

    while True:
        try:
            a = int(input(f"\t\t\t\t\t{'Enter the Row number   :'}"))
            b = int(input(f"\t\t\t\t\t{'Enter the Column Number:'}"))
        except ValueError:
            printc("Try Again")
            continue
        if a in [num for num in range(1, 4)] and b in [num for num in range(1, 4)] and (a, b) not in moves:
            break
        else:
            printc("Try Again")
    moves.add((a, b))
    data[a-1][b-1] = symbol


def check4victory():
    return (data[0][0] == data[0][1] == data[0][2] != ' ' or
            data[1][0] == data[1][1] == data[1][2] != ' ' or
            data[2][0] == data[2][1] == data[2][2] != ' ' or
            data[0][0] == data[1][0] == data[2][0] != ' ' or
            data[0][1] == data[1][1] == data[2][1] != ' ' or
            data[0][2] == data[1][2] == data[2][2] != ' ' or
            data[0][0] == data[1][1] == data[2][2] != ' ' or
            data[2][0] == data[1][1] == data[0][2] != ' ')


printc("TIC - TAC GAME")
while True:
    data = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
    moves = {(0, 0)}
    game_board_printc()
    player = random.choice((1, -1))
    for i in range(0, 9):
        if player == -1:
            turn = 'Tic'
            turn_symbl = 'X'
        else:
            turn = 'Tac'
            turn_symbl = 'O'
        printc(f"{turn} Turn")
        printc(f"{'*'*25}")
        player_input_data_update(turn_symbl)
        game_board_printc()
        if check4victory():
            printc(f"{turn.upper()} WON\n")
            break
        player *= -1
    else:
        printc("Draw Game")
    if input("\nDo You Want to Play Again [Y/N]: ").upper() != 'Y':
        break
