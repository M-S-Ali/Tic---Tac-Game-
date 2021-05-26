#include <iostream>

char data[3][3] = { {' ',' ',' '},{' ',' ',' '},{' ',' ',' '} };
int available[3][3] = { {0,0,0},{0,0,0},{0,0,0} };


void print(const char* txt) {
    std::cout << "\t\t\t\t\t" << txt;
}


void print_board(){
    std::cout.width(66); std::cout
        << " _______ _______ _______ \n"
        << "\t\t\t\t\t|       |       |       |\n\t\t\t\t\t"
        << "|   " << data[0][0] << "   "
        << "|   " << data[0][1] << "   "
        << "|   " << data[0][2] << "   |\n\t\t\t\t\t"
        << "|_______|_______|_______|\n\t\t\t\t\t"
        << "|       |       |       |\n\t\t\t\t\t"
        << "|   " << data[1][0] << "   "
        << "|   " << data[1][1] << "   "
        << "|   " << data[1][2] << "   |\n\t\t\t\t\t"
        << "|_______|_______|_______|\n\t\t\t\t\t"
        << "|       |       |       |\n\t\t\t\t\t"
        << "|   " << data[2][0] << "   "
        << "|   " << data[2][1] << "   "
        << "|   " << data[2][2] << "   |\n\t\t\t\t\t"
        << "|_______|_______|_______|\n";
}


void input_update(char mark) {
    int r, c;
    while (true) {
        r = 0; c = 0;
        print("Enter the Row Number: ");
        std::cin >> r;
        print("Enter the Column Number: ");
        std::cin >> c;
        if (std::cin.fail()){
            std::cout << "\n";
            print("Invlid Input!! Try Again\n\n");
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        }
        else {
            if (r < 4 && r > 0 && c < 4 && c > 0) {
                if (available[r - 1][c - 1] == 0) {
                    data[r - 1][c - 1] = mark;
                    available[r - 1][c - 1] = 1;
                    break;
                }
                else {
                    std::cout << "\n";
                    print("Move Unavailable, Please try again\n\n");
                }
            }
            else {
                std::cout << "\n";
                print("Out of Range, Please try again\n\n");
            }
        }
    }
}


bool check4victory() {
    return  ((data[0][0] == data[0][1]) && (data[0][0] == data[0][2]) && (data[0][1] != ' ' )||
            (data[1][0] == data[1][1]) && (data[1][0] == data[1][2]) && (data[1][0] != ' ' )||
            (data[2][0] == data[2][1]) && (data[2][0] == data[2][2]) && (data[2][0] != ' ' )||
            (data[0][0] == data[1][0]) && (data[0][0] == data[2][0]) && (data[0][0] != ' ' )||
            (data[0][1] == data[1][1]) && (data[0][1] == data[2][1]) && (data[0][1] != ' ' )||
            (data[0][2] == data[1][2]) && (data[0][2] == data[2][2]) && (data[0][2] != ' ' )||
            (data[0][0] == data[1][1]) && (data[0][0] == data[2][2]) && (data[0][0] != ' ' )||
            (data[2][0] == data[1][1]) && (data[2][0] == data[0][2]) && (data[2][0] != ' ' ));
}


int main() {
    char play_again;
    int i;
    while (true) {
        int user = 1;
        char mark;
        const char* name;
        std::cout << "\n\n";
        print("     Tic Tac Toe Game\n");
        print_board();
        for (i = 0; i < 9; i++) {
            if (user == 1) {
                mark = 'X';
                name = "Tic";
            }
            else {
                mark = 'O';
                name = "Tac";
            }
            print("\t");
            std::cout << name;
            std::cout << " Turn\n";
            input_update(mark);
            print_board();
            if (check4victory()) {
                print("\t");
                std::cout << name;
                std::cout << " Won";
                break;
            }
            user = user * -1;
        }
        if (i == 9) {
            print("\t Draw Game");
        }
        std::cout << "\n";
        print("Play Again [Y/N]: ");
        std::cin >> play_again;
        if ((play_again == 'Y') || (play_again == 'y')) {
            for (i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    data[i][j] = ' ';
                    available[i][j] = 0;
                }
            }
            continue;
        }
        break;
    }
}
