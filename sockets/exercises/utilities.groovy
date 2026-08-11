import java.util.Scanner

def InputGroovy(msg){
    def scanner = new Scanner(System.in)
    print msg
    return scanner.nextLine()
}