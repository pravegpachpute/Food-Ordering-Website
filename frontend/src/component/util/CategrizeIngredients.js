// logic map all ingredints our category

export const categorizeIngredients = (ingredints) => {
  return ingredints.reduce((acc, ingredient) => {
    const { category } = ingredient;
    if (!acc[category.name]) {
      acc[category.name] = [];
    }
    acc[category.name].push(ingredient);
    return acc;
  }, {});
};

// {}= empty acc mean accumalator
