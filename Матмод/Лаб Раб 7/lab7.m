clear, clc

A = [
    0.1, 0.5, 0.4, 0, 0, 0, 0;
    0, 0.7, 0.3, 0, 0, 0, 0;
    0.2, 0.1, 0.7, 0, 0, 0, 0;
    0, 0, 0, 0.3, 0.1, 0, 0.6;
    0.1, 0.7, 0, 0.1, 0, 0.1, 0;
    0.9, 0, 0, 0, 0, 0.1, 0;
    0, 0, 0, 0.3, 0.1, 0.2, 0.4
];

A3 = A * A * A

P0 = [0, 0, 0, 0.1, 0.2, 0.4, 0.3]

P3 = P0 * A3

Anev = [
    0.3, 0.1, 0, 0.6;
    0.1, 0, 0.1, 0;
    0, 0, 0.1, 0;
    0.3, 0.1, 0.2, 0.4;
];

N = (eye(4) - Anev)^(-1)

tao = zeros(4,1);
for i = 1 : 4
    for j = 1 : 4
        tao(i,1) = tao(i,1) + N(i,j);
    end
end
tao

D = (2*N - eye(4))*tao - abs(tao.^2)

delta = sqrt(D)

U = [
    0.3333, 0.3333, 0.3333;
    0.3333, 0.3333, 0.3333;
    0.3333, 0.3333, 0.3333;
    0.3333, 0.3333, 0.3333;
    0.3333, 0.3333, 0.3333;
    0.3333, 0.3333, 0.3333;
    0.3333, 0.3333, 0.3333;
];

P0 = [0.2, 0.3, 0, 0, 0, 0.1, 0.4];
P0 * U

P0 = [0, 0.3, 0.1, 0, 0.25, 0.15, 0.2];
P0 * U

P0 = [0.1, 0.2, 0.2, 0, 0, 0.2, 0.3];
P0 * U