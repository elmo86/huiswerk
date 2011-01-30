#include <iostream>
#include <cctype>

using namespace std;

bool chekMode(char);
string coding(string, int);
string decoding(string, int);

int main()
{
  char mode = '?';
  
  string code;
  int Sleutel = -1;

  while(!chekMode(mode)) {
    cout << "Selecteer welke mode u wilt gebruiken:\n  c voor coderen\n  d voor decoderen\nModus: ";
    cin >> mode;
    cin.get();
  }

  cout << "Tiep je code maar in die je wilt bewerken (eindig met een enter)" << endl;
  cin >> code;
  cin.get();

  while(Sleutel < 0 || Sleutel > 26) {
    cout << "Met welke sleutel wilt u de code bewerken (Cijver tussen de 0 en 26)" << endl;
    cin >> Sleutel;
    cin.get();
  }
  
  if(mode == 'c' || mode == 'C') {
    cout << "Uw gecodeerde code: " << endl << coding(code, Sleutel) << endl;
  }
  else if(mode == 'd' || mode == 'D') {
    cout << "Uw gedecodeerde code: " << endl << decoding(code, Sleutel) << endl;
  }

  return 0;
}

bool chekMode(char mode)
{
  if(mode == 'c') return true;
  if(mode == 'C') return true;
  if(mode == 'd') return true;
  if(mode == 'D') return true;
  return false;
}

string coding(string code, int Sleutel)
{
  bool up = false;

  for(int i=0;i<code.length();i++) {
    if(isalpha(code[i])) {
      if(isupper(code[i])) { code[i] = tolower(code[i]); up = true; } else { up = false; } 

      code[i] += Sleutel;
      
      if(code[i] > 'z' || code[i] < 'a') { code[i] -= 26; }

      if(up) code[i] = toupper(code[i]);
    }
  }

  return code;
}

string decoding(string code, int Sleutel)
{
  bool up = false;

  for(int i=0;i<code.length();i++) {
    if(isalpha(code[i])) {
      if(isupper(code[i])) { code[i] = tolower(code[i]); up = true; } else { up = false; } 

      code[i] -= Sleutel;
      
      if(code[i] > 'z' || code[i] < 'a') { code[i] += 26; }

      if(up) code[i] = toupper(code[i]);
    }
  }

  return code;
}
