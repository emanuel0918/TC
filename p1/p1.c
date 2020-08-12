#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int cadenaEsNumero (char **cadena);
int cadenaANumero (char **cadena);
int scan (char **cadena);
void numeroABinario (char **cadena, long n, int bits);
int main ()
{
  int n, i, l, opc;
  long o;
  char *cadena, *s_opc, *s_n;
  FILE *archivo;
  do
    {
      printf ("Generador de universo Sigma hasta n\n");
      printf ("1)Generar universo de manera manual\n");
      printf ("2)Generar universo de manera aleatoria\n");
      printf ("3)Salir\n");
      scan (&s_opc);
    }
  while (!(cadenaEsNumero (&s_opc)));
  opc = cadenaANumero (&s_opc);
  if (opc >= 1 && opc <= 2)
    {
      if (opc == 1)
	{
	  printf ("Ingrese la n de Sigma:\n");
	  do
	    {
	      scan (&s_n);
	    }
	  while (!(cadenaEsNumero (&s_n)));
	  n = cadenaANumero (&s_n);
	}
      if (opc == 2)
	{
	  srand (time (NULL));
	//numero aleatorio entre 1 y 100
	  n = rand () % (101);
	  printf ("Universo hecho aleatoriamente hasta %d\n",n);
	}
      system ("rm sigma.txt");
      system ("echo > sigma.txt");
      archivo = fopen ("sigma.txt", "w");
      if (i >= 0)
	{
	  fprintf (archivo, "{%c", 163);
	  for (i = 0; i < n; i++)
	    {
	      for (o = 1, l = 2; o < i + 1; o++)
		l *= 2;
	      for (o = 0; o < l; o++)
		{
		  fprintf (archivo, ",");
		  numeroABinario (&cadena, o, i + 1);
		  fprintf (archivo, "%s", cadena);
		}
	    }
	  fprintf (archivo, "}\n");
	  printf ("Se ha creado el archivo\n");
	}
      fclose (archivo);
    }
  return 0;
}

void numeroABinario (char **cadena, long n, int bits)
{
  int i;
  char *rev;
  i = 0;
  *cadena = (char *) calloc (bits, sizeof (char));
  rev = (char *) calloc (bits, sizeof (char));
  while (n > 0)
    {
      (*cadena)[i] = (n % 2) + 48;
      n /= 2;
      i++;
    }
  while (i < bits)
    {
      (*cadena)[i] = '0';
      i++;
    }
  i = 0;
  while (i < bits)
    {
      rev[i] = (*cadena)[bits - 1 - i];
      i++;
    }
  rev[i] = '\0';
  i = 0;
  while (rev[i] != '\0')
    {
      (*cadena)[i] = rev[i];
      i++;
    }
  (*cadena)[i] = '\0';
}

int cadenaANumero (char **cadena)
{
  int d = 0, l = 0, i, j, b;
  while ((*cadena)[l] != '\0')
    {
      l++;
    }
  for (i = 0; i < l; i++)
    {
      b = 1;
      for (j = 1; j < (l - i); j++)
	{
	  b *= 10;
	}
      d += ((*cadena)[i] - 48) * b;
    }
  return d;
}

int cadenaEsNumero (char **cadena)
{
  int numero = 1;
  int i = 0;
  while ((*cadena)[i] != '\0')
    {
      if (!((*cadena)[i] >= 48 && (*cadena)[i] <= 57))
	{
	  numero = 0;
	  break;
	}
      i++;
    }
  if (i < 1)
    {
      numero = 0;
    }
  return numero;
}

int scan (char **cadena)
{
  char c;
  int i = 0;
  *cadena = (char *) malloc (sizeof (char));
  setbuf (stdin, NULL);
  while (c != '\n')
    {
      c = getc (stdin);
      if (c != '\n')
	{
	  (*cadena)[i] = c;
	  i++;
	  *cadena = (char *) realloc (*cadena, sizeof (char) * (i + 1));
	}
    }
  (*cadena)[i] = '\0';
  return i;
}
