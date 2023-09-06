export const categoryPresenterMock = () => {

    const res = {
        category : {
            idCategory: 1,
            name: 'comidas',
        },
        recipes: [
            {
                idCategory: 1,
                name: 'comidas',
            },
            {
                idCategory: 2,
                name: 'postres',
            },
        ]
    }
    
    const getMock = () => {
        return res   
    }

    return {
        getMock,
    }
}