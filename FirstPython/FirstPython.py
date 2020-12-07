import random

play = True

while play == True:
    a = False
    b = False
    c = False

    x = random.randint(0, 2)

    ace = ""

    if x == 0:
        ace = "a"

    elif x == 1:
        ace = "b"

    elif x == 2:
        ace = "c"

    else:
        play = False
        break

    print(ace)
    # print(x)
    # print(str(a) + "\n" + str(b) + "\n" + str(c))

    card = input("Pick the Ace: is it \'a\', \'b\', or \'c\'?\n")

    if card != "a" and card != "b" and card != "c":
        print("end")
        play = False
        break

    randomCard = "a"
    count = 0
    if card == ace:
        while randomCard == ace or randomCard == card:
            if count % 3 == 0:
                randomCard = "a"
            if count % 3 == 1:
                randomCard = "b"
            if count % 3 == 2:
                randomCard = "c"
            count = count + 1
    else:
        randomCard = ace

    notAce = "a"
    while notAce == ace or notAce == card or notAce == randomCard:
        if count % 3 == 0:
            notAce = "a"
        if count % 3 == 1:
            notAce = "b"
        if count % 3 == 2:
            notAce = "c"
        count = count + 1

    print("You pick card \'" + card + "\'. Unexpectedly, you are shown that card \'" + notAce + "\' is not the Ace")
    choice = input("You are given another choice: STAY with \'" + card + "\' or SWITCH to \'" + randomCard + "\'?\n")
    print("Your initial choice was card \'" + card + "\'.")

    if choice == "stay":
        card = card
    elif choice == "switch":
        card = randomCard
    else:
        play = False
        print("end")
        break

    print("Your final choice was card \'" + card + "\'.")

    if card == ace:
        print("You Won!")
    else:
        print("You Lost!")

    print("The Ace was card \'" + ace + "\'.")

    play = False
    break
