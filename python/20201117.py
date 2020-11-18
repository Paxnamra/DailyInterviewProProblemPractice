# Nov 17 2020
# A k-ary tree is a tree with k-children, and a tree is symmetrical if the data of the left side of the tree is the same as the right side of the tree.

class Node():
    def __init__(self, value, children=[]):
        self.value = value
        self.children = children

def is_symmetric(root):
    left = extract_data_left(root.children[0])
    right = extract_data_right(root.children[1])
    if left == right:
        return True
    return False
    # print(left)
    # print(right)

def extract_data_left(root):
    if root.children == []:
        return root.value
    else:
            return [root.value] + [ extract_data_left(i) for i in root.children ]

def extract_data_right(root):
    if root.children == []:
        return root.value
    else:
            return [root.value] + [ extract_data_right(i) for i in reversed(root.children) ]



tree = Node(4)
tree.children = [Node(3), Node(3)]
tree.children[0].children = [Node(9), Node(4), Node(1)]
tree.children[1].children = [Node(1), Node(4), Node(9)]
print(is_symmetric(tree))
# is_symmetric(tree)