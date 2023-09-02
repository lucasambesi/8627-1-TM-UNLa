export const recipePresenterMock = () => {

    const res = {
        recipe : {
            idUser: 1,
            userName: 'lucasambesi',
        },
        recipes: [
            {
                idRecipe: 1,
                idUser: 1,
                title: 'Milanesas con pure',
                description: 'Milanesas con pure description',
                ingredients: '1 milanesa, 2 papas, menteca, sal, pan rallado, etc',
                category: 1,
                preparationTime: '100',
            },
            {
                idRecipe: 1,
                idUser: 1,
                title: 'Milanesas con ensalada',
                description: 'Milanesas con ensalada description',
                ingredients: '1 milanesa, lechuga, tomate, 2 huevos, sal, vinagre, etc',
                category: 1,
                preparationTime: '70',
            },
            {
                idRecipe: 1,
                idUser: 1,
                title: 'Pastel de papas',
                description: 'Pastel de papas description',
                ingredients: '1.5 kilos de papas, lechuga, taza de leche,taza de crema, 2 cucharadas grandes manteca, sal',
                category: 1,
                preparationTime: '60',
            }
        ]
    }
    
    const getMock = () => {
        return res   
    }

    return {
        getMock,
    }
}